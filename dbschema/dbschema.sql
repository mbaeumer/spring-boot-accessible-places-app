-- Create the AppUserType table
CREATE TABLE AppUserType
(
    id          INT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(320) UNIQUE
);

-- Create the AppUser table
CREATE TABLE AppUser
(
    id         INT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(320) UNIQUE,
    userTypeId INT,
    CONSTRAINT fk_appUser_userType FOREIGN KEY (userTypeId) REFERENCES AppUserType (id)
);

-- Create the GoogleRequestType table
CREATE TABLE GoogleRequestType
(
    id          INT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    code        VARCHAR(255) UNIQUE,
    description VARCHAR(255) NOT NULL
);

-- Create the GoogleRequest table
CREATE TABLE GoogleRequest
(
    id            INT PRIMARY KEY,
    payload       VARCHAR(255) NOT NULL,
    executionTime TIMESTAMP    NOT NULL,
    requestTypeId INT,
    userId        INT,
    CONSTRAINT fk_googleRequest_requestType FOREIGN KEY (requestTypeId) REFERENCES GoogleRequestType (id),
    CONSTRAINT fk_googleRequest_user FOREIGN KEY (userId) REFERENCES AppUser (id)
);

-- Create the HotSpot table
CREATE TABLE HotSpot
(
    id            INT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    address       VARCHAR(255) NOT NULL,
    googleApiCode VARCHAR(255) NOT NULL,
    userId        INT,
    CONSTRAINT fk_hotSpot_user FOREIGN KEY (userId) REFERENCES AppUser (id)
);

-- Create the Location table
CREATE TABLE Location
(
    id                 INT PRIMARY KEY,
    businessStatus     VARCHAR(255) NOT NULL,
    name               VARCHAR(255) NOT NULL,
    formattedAddress   VARCHAR(255) NOT NULL,
    googleApiCode      VARCHAR(255) NOT NULL,
    latitude           VARCHAR(255) NOT NULL,
    longitude          VARCHAR(255) NOT NULL,
    created            TIMESTAMP    NOT NULL,
    lastUpdated        TIMESTAMP    NOT NULL,
    userId             INT,
    accessibleEntrance VARCHAR(1)   NOT NULL,
    accessibleSeating  VARCHAR(1)   NOT NULL,
    accessibleRestRoom VARCHAR(1)   NOT NULL,
    CONSTRAINT fk_location_user FOREIGN KEY (userId) REFERENCES AppUser (id)
);
