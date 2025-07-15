package com.devteria.profile.controller;


import com.devteria.profile.dto.request.ProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/users")
    UserProfileResponse userProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createUserProfile(request);
    }

    @GetMapping("/users/{profileId}")
    UserProfileResponse getProfile(@PathVariable UUID profileId) {
        return userProfileService.getProfile(profileId);
    }
}
