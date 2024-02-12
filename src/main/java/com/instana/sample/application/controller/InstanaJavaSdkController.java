package com.instana.sample.application.controller;

import com.instana.sample.application.model.Profile;
import com.instana.sample.application.service.ProfileService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/instana/")
class InstanaJavaSdkController {

    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/profile", produces = "application/json")
    public List<Profile> getAll(@RequestParam(name = "error") Boolean error) {
        return profileService.all(error);
    }

    @PostMapping(value = "/app", produces = "application/json")
    public Profile create(@RequestBody Profile profile) {
        return profileService.create(profile.getName(), profile.getEmployer(), profile.getEmail());
    }
}
