package se.mbaeumer.accessible.places.requesttracking;

public class GoogleRequestTypeDto {
    private Integer id;
    private String name;
    private String code;
    private String description;

    private GoogleRequestTypeDto(Integer id, String name, String code, String description){
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public static GoogleRequestTypeDto of(GoogleRequestType googleRequestType){
        return new GoogleRequestTypeDto(googleRequestType.getId(), googleRequestType.getName(),
                googleRequestType.getCode(), googleRequestType.getDescription());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
