# Theater-System
A simulation of purchasing tickets from a movie theater website.

### Description
#### Webpages 
##### Index:
  Index is the first page a user is introduced to. This page 
  asks the user to input a Zip code to begin. The user can only
  input numbers into the text field and must input 5. Once the 
  user has input 5 digits, the search button enables and the user
  is taken to the TheaterSelect page.
  
  ![Index](Images/1-Start%20Page.PNG?raw=true)
  
##### TheaterSelect:
  Using the user's Zip code, the TheaterSelect page searches the
  database for theaters in that zip code. Then, it populates the
  webpage with all the theaters in that location along with their
  logo, address, and description. The user then selects a theater
  and is taken to the MovieSelct page.
  
  ![TheaterSelect](Images/3-Theater%20Selection.PNG?raw=true)
  
##### MovieSelect:
  After obtaining the theater location in the TheaterSelect page, 
  MovieSelect brings up a page with all the movies currently playing
  in that theater as well as their poster, description, and show
  times. The user can then select a show time they would like to 
  attend and will be taken to the Payment page.
  
  ![Movie Select](Images/4-Movie%20Time%20Selection.PNG?raw=true)
  
##### Payment:
  On this page, the user is allowed to increase the number of
  tickets they would like to purchase. Each ticket is $10 and
  the page will reflect this information in a 'Total' section.
  Then, the user must input their name and credit card information.
  The credit card section only allows for the user to input numbers
  and they must input 16 numbers. The EXP and CVV also only take
  numbers as input. Once all of the boxes on this page have been
  filled, the submit button enables and the user can click it to 
  be brought to a confirmation page.
  
  ![Payment](Images/5-Payment%20Page.PNG?raw=true)
  
##### Confirmation:
  The confirmation page uses the information we have gained from
  the previous two pages and displays a message with the name of
  the movie as well as the number of tickets the user has purchased.
  Once the user is done, they can use the return button to be brought
  back to the index page.
  
  ![Confirmation](Images/6-Confirmation%20Page.PNG?raw=true)

#### Beans:
##### TheaterBean:
  This bean is used by every page to execute all their functions.
  This bean will return the strings that take the users to the next pages
  as well as execute functions that enable certain buttons. This will 
  also be used to store information from each page that will be used later
  in the application. 

#### EJB:
##### TheaterEJB:
  This EJB is used to communicate with the entity manager and pull information
  from the entities. 

#### Entities:
##### Locations:
  This entity is used to store and access the Locations table in the database.
  This table stores all the information about theaters.
##### Movies:
  This entity is used to access information from the Movies table in the database.
  This table contains all the information about each movie.
##### Times and TimesPK:
  These entities are used to access information about the times a movie plays at
  a certain theater.

### How to run
* This program requires the use of Prime Faces. This must be added into your project library. 
* This project also requires a SQL database connection. A sample SQL script is provided with this project. However, you must add your own movie images and theater logo images.
* You must create a persistence unit for the data base.
