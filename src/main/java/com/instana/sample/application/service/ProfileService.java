package com.instana.sample.application.service;

import com.instana.sample.application.model.Profile;
import com.instana.sample.application.repository.ProfileRepository;
import com.instana.sdk.annotation.Span;
import com.instana.sdk.support.SpanSupport;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProfileService {
    private final String SPAN_NAME = "custom-instana-java-sdk";
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Span(type = Span.Type.INTERMEDIATE, value = SPAN_NAME)
    public List<Profile> all(Boolean error) {
        try {
            if (error) {
                throw new Exception();
            }
            SpanSupport.annotate(Span.Type.INTERMEDIATE, SPAN_NAME, "tags.instana.java.sdk", "Success");
            return getAll();
        } catch (Exception e) {
            SpanSupport.annotate(Span.Type.INTERMEDIATE, SPAN_NAME, "tags.error", "true");
            SpanSupport.annotate(Span.Type.INTERMEDIATE, SPAN_NAME, "tags.instana.java.sdk", "Fail");
        }
        return Collections.emptyList();
    }

    private List<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Profile create(String name, String employer, String email) {
        Profile p = new Profile();
        p.setName(name);
        p.setEmployer(employer);
        p.setEmail(email);
        return profileRepository.save(p);
    }
}
