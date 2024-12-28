-- DROP TABLE GoogleRequest IF EXISTS;
-- DROP TABLE Location IF EXISTS;
-- DROP TABLE HotSpot IF EXISTS;
-- DROP TABLE AppUser IF EXISTS;
-- DROP TABLE AppUserType IF EXISTS;
-- DROP TABLE GoogleRequestType IF EXISTS;
--
--
-- -- Create the AppUserType table
-- CREATE TABLE AppUserType
-- (
--     id          INT PRIMARY KEY,
--     name        VARCHAR(255) NOT NULL,
--     description VARCHAR(320) UNIQUE
-- );
--
-- -- Create the AppUser table
-- CREATE TABLE AppUser
-- (
--     id         INT PRIMARY KEY,
--     name       VARCHAR(255) NOT NULL,
--     email      VARCHAR(320) UNIQUE,
--     userTypeId INT,
--     CONSTRAINT fk_appUser_userType FOREIGN KEY (userTypeId) REFERENCES AppUserType (id)
-- );
--
-- -- Create the GoogleRequestType table
-- CREATE TABLE GoogleRequestType
-- (
--     id          INT PRIMARY KEY,
--     name        VARCHAR(255) NOT NULL,
--     code        VARCHAR(255) UNIQUE,
--     description VARCHAR(255) NOT NULL
-- );
--
-- -- Create the GoogleRequest table
-- CREATE TABLE GoogleRequest
-- (
--     id            INT PRIMARY KEY,
--     payload       VARCHAR(255) NOT NULL,
--     executionTime TIMESTAMP    NOT NULL,
--     requestTypeId INT,
--     userId        INT,
--     CONSTRAINT fk_googleRequest_requestType FOREIGN KEY (requestTypeId) REFERENCES GoogleRequestType (id),
--     CONSTRAINT fk_googleRequest_user FOREIGN KEY (userId) REFERENCES AppUser (id)
-- );
--
-- -- Create the HotSpot table
-- CREATE TABLE HotSpot
-- (
--     id            INT PRIMARY KEY,
--     name          VARCHAR(255) NOT NULL,
--     address       VARCHAR(255) NOT NULL,
--     googleApiCode VARCHAR(255) NOT NULL,
--     userId        INT,
--     CONSTRAINT fk_hotSpot_user FOREIGN KEY (userId) REFERENCES AppUser (id)
-- );
--
-- -- Create the Location table
-- CREATE TABLE Location
-- (
--     id                 INT PRIMARY KEY,
--     businessStatus     VARCHAR(255) NOT NULL,
--     name               VARCHAR(255) NOT NULL,
--     formattedAddress   VARCHAR(255) NOT NULL,
--     googleApiCode      VARCHAR(255) NOT NULL,
--     latitude           VARCHAR(255) NOT NULL,
--     longitude          VARCHAR(255) NOT NULL,
--     created            TIMESTAMP    NOT NULL,
--     lastUpdated        TIMESTAMP    NOT NULL,
--     userId             INT,
--     accessibleEntrance VARCHAR(1)   NOT NULL,
--     accessibleSeating  VARCHAR(1)   NOT NULL,
--     accessibleRestRoom VARCHAR(1)   NOT NULL,
--     CONSTRAINT fk_location_user FOREIGN KEY (userId) REFERENCES AppUser (id)
-- );

INSERT INTO AppUserType(id, name, description) VALUES(1, 'ADMIN', 'description');
INSERT INTO AppUser(id, name, email, userTypeId) VALUES(1, 'Martin Bäumer', 'mb@mb.se', 1);
INSERT INTO GoogleRequestType (id, name, code, description)
VALUES (1, 'Search Request', 'SEARCH', 'A request for performing a search operation.');
INSERT INTO GoogleRequest (id, payload, executionTime, requestTypeId, userId)
VALUES (0, 'Search for restaurants in New York', '2024-12-11 14:30:00', 1, 1);
INSERT INTO HotSpot(id, name, address, googleApiCode, userId)
VALUES(0, 'My fake hotspot', 'My fake address 21', 'api-code-123', 1);
INSERT INTO Location(id, businessStatus, name, formattedAddress, googleApiCode, latitude, longitude, created, lastUpdated, userId,
                     accessibleEntrance, accessibleSeating, accessibleRestRoom)
VALUES (0, 'ACTIVE','LOCATIONNAME', 'ADDRESS','APICODE','LATITUDE', 'LONGITUDE', '2024-12-11 14:30:00', '2024-12-11 14:33:00', 1,
        'YES', 'YES', 'YES');


