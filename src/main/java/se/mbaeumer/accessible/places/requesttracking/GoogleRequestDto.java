package se.mbaeumer.accessible.places.requesttracking;

import se.mbaeumer.accessible.places.users.AppUser;

import java.sql.Timestamp;

public class GoogleRequestDto {

    private Integer id;

    private String payload;

    private Timestamp executionTime;

    private GoogleRequestTypeDto googleRequestTypeDto;

    private AppUser appUser;

    private GoogleRequestDto(Integer id, String payload, Timestamp executionTime, GoogleRequestType googleRequestType, AppUser appUser){
        this.id = id;
        this.payload = payload;
        this.googleRequestTypeDto = GoogleRequestTypeDto.of(googleRequestType);
        this.executionTime = executionTime;
    }

    public static GoogleRequestDto of(GoogleRequest googleRequest){
        return new GoogleRequestDto(googleRequest.getId(), googleRequest.getPayload(), googleRequest.getExecutionTime(),
                googleRequest.getRequestType(), googleRequest.getUser());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Timestamp getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Timestamp executionTime) {
        this.executionTime = executionTime;
    }

    public GoogleRequestTypeDto getGoogleRequestTypeDto() {
        return googleRequestTypeDto;
    }

    public void setGoogleRequestTypeDto(GoogleRequestTypeDto googleRequestTypeDto) {
        this.googleRequestTypeDto = googleRequestTypeDto;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
