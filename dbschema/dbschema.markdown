

Table AppUserType

Columns for this table:

| **Column Name** | **Data Type** | **Length** | **Constraints** | **Description**                     |
|-----------------|---------------|------------|-----------------|-------------------------------------|
| `id`            | `INT`         | -          | `PRIMARY KEY`   | Unique identifier.                  |
| `name`          | `VARCHAR`     | 255        | `NOT NULL`      | The name of the user type.          |
| `description`   | `VARCHAR`     | 320        | `UNIQUE`        | The descriiption of the user type.  |


Table AppUser

Columns for this table:

| **Column Name** | **Data Type** | **Length** | **Constraints**              | **Description**                |
|-----------------|---------------|------------|------------------------------|--------------------------------|
| `id`            | `INT`         | -          | `PRIMARY KEY`                | Unique identifier.             |
| `name`          | `VARCHAR`     | 255        | `NOT NULL`                   | The full name of the user.     |
| `email`         | `VARCHAR`     | 320        | `UNIQUE`                     | The email address of the user. |
| `userTypeId`    | `INT`         | -          | `FOREIGN KEY TO AppUserType` | The user type of the user.     |


Table GoogleRequestType

Columns for this table:

| **Column Name** | **Data Type** | **Length** | **Constraints**  | **Description**                     |
|-----------------|---------------|------------|------------------|-------------------------------------|
| `id`            | `INT`         | -          | `PRIMARY KEY`    | Unique identifier.                  |
| `name`          | `VARCHAR`     | 255        | `NOT NULL`       | The name of the request type        |
| `code`          | `VARCHAR`     | 255        | `UNIQUE`         | The code of the request type        |
| `description`   | `VARCHAR`     | 255        | `NOT NULL`       | The description of the request type | 


Table GoogleRequest

Columns for this table:

| **Column Name** | **Data Type** | **Length** | **Constraints**                    | **Description**                    |
|-----------------|---------------|------------|------------------------------------|------------------------------------|
| `id`            | `INT`         | -          | `PRIMARY KEY`                      | Unique identifier.                 |
| `payload`       | `VARCHAR`     | 255        | `NOT NULL`                         | The payload used in this request   |
| `executionTime` | `TIMESTAMP`   | -          | `NOT NULL`                         | The execution time of the request  |
| `requestTypeId` | `INT`         | -          | `FOREIGN KEY TO GoogleRequestType` | The type of the request            |
| `userId`        | `INT`         | -          | `FOREIGN KEY TO AppUser`           | The user that executed the request |


Table HotSpot

Columns for this table:

| **Column Name** | **Data Type** | **Length** | **Constraints**          | **Description**                  |
|-----------------|---------------|------------|--------------------------|----------------------------------|
| `id`            | `INT`         | -          | `PRIMARY KEY`            | Unique identifier.               |
| `name`          | `VARCHAR`     | 255        | `NOT NULL`               | The name of the hotspot          |
| `address`       | `VARCHAR`     | 255        | `NOT NULL`               | The address of the hotspot       |
| `googleApiCode` | `VARCHAR`     | 255        | `NOT NULL`               | The Google API code              |
| `userId`        | `INT`         | -          | `FOREIGN KEY TO AppUser` | The user who created the hotspot |


Table Location

//TODO: columns for location type (maybe more?)
Columns for this table:

| **Column Name**      | **Data Type** | **Length** | **Constraints**          | **Description**                           |
|----------------------|---------------|------------|--------------------------|-------------------------------------------|
| `id`                 | `INT`         | -          | `PRIMARY KEY`            | Unique identifier.                        |
| `businessStatus`     | `VARCHAR`     | 255        | `NOT NULL`               | The business status of the location       |
| `name`               | `VARCHAR`     | 255        | `NOT NULL`               | The name of the location                  |
| `formattedAddress`   | `VARCHAR`     | 255        | `NOT NULL`               | The address of the location               |
| `googleApiCode`      | `VARCHAR`     | 255        | `NOT NULL`               | The Google API code of the location       |
| `latitude`           | `VARCHAR`     | 255        | `NOT NULL`               | The latitude of the location              |
| `longitude`          | `VARCHAR`     | 255        | `NOT NULL`               | The longitude of the location             |
| `created`            | `TIMESTAMP`   | -          | `NOT NULL`               | The creation time of the location         |
| `lastUpdated`        | `TIMESTAMP`   | -          | `NOT NULL`               | The updated time of the location          |
| `userId`             | `INT`         | -          | `FOREIGN KEY TO AppUser` | The creator of the location               |
| `accessibleEntrance` | `VARCHAR`     | 1          | `NOT NULL`               | Flag indicating if entrance is accessible |
| `accessibleSeating`  | `VARCHAR`     | 1          | `NOT NULL`               | Flag indicating if seating is accessible  |
| `accessibleRestRoom` | `VARCHAR`     | 1          | `NOT NULL`               | Flag indicating if restroom is accessible |




