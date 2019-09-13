CREATE TABLE Locations(
    TheaterID CHAR (2) NOT NULL,
    Name VARCHAR (50),
    Address VARCHAR (50),
    City VARCHAR (50),
    State VARCHAR (20),
    Zip CHAR (5),
    Logo VARCHAR (100),
    PRIMARY KEY (TheaterID)
);

CREATE TABLE Movies(
    MovieID CHAR (2) NOT NULL,
    Title VARCHAR (50),
    Description VARCHAR (500),
    Image VARCHAR (100),
    PRIMARY KEY (MovieID)
);

CREATE TABLE Times(
    TheaterID CHAR (2) NOT NULL,
    MovieID CHAR (2) NOT NULL,
    Time CHAR (8),
    FOREIGN KEY(MovieID) REFERENCES Movies(MovieID),
    FOREIGN KEY(TheaterID) REFERENCES Locations(TheaterID),
    PRIMARY KEY (MovieID, TheaterID, Time)
);

INSERT INTO Locations (TheaterID, Name, Address, City, State, Zip, Logo)
VALUES('ID of theater', 'Name of theater', 'Address of theater', 'City', 'State', 'Zip Code', 'File path to image');

INSERT INTO Movies(MovieID, Title, Description, Image)
VALUES('ID of movie', 'Movie title', 'Description','File path to image');

INSERT INTO Times(TheaterID, MovieID, Time)
VALUES('Theater ID','Movie ID','Time of showing');

