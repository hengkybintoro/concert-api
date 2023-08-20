1. Database Schema

The database consists of two main tables:

    Concert
    Ticket

2. Table Descriptions
Concert

    Fields:
        id (Primary Key)
        name (String)
        start_time (Timestamp)
        venue (String)
    Description: This table stores information about concerts, including the concert's name, start time, and venue.

Ticket

    Fields:
        id (Primary Key)
        concert_id (Foreign Key referencing Concert table)
        attendee_name (String)
    Description: This table stores ticket information, including the associated concert and the name of the attendee.

3. Table Queries
Concert

    CREATE TABLE concert (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        start_time TIMESTAMP NOT NULL,
        venue VARCHAR(255) NOT NULL
    );

Ticket

    CREATE TABLE ticket (
        id SERIAL PRIMARY KEY,
        concert_id INT REFERENCES concert(id) ON DELETE CASCADE,
        attendee_name VARCHAR(255) NOT NULL
    );