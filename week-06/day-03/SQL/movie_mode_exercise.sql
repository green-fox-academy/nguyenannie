/*Q1: Add the reviewer Roger Ebert to your database, with an rID of 209. */
INSERT INTO Reviewer VALUES(209, 'Roger Ebert');

/*Q2: Insert 5-star ratings by James Cameron for all movies in the database. Leave the review date as NULL. */
INSERT INTO Rating ( rID, mID, stars, ratingDate )
SELECT Reviewer.rID , Movie.mID, 5, null FROM Movie
LEFT JOIN Reviewer
WHERE Reviewer.name='James Cameron';

/*Q3: For all movies that have an average rating of 4 stars or higher, add 25 to the release year. (Update the existing tuples; don't insert new tuples.) */
UPDATE Rating
	SET ratingDate = DATE_ADD(ratingDate, INTERVAL 20 year)
	WHERE mId IN (SELECT tb1.mvid 
				  FROM (SELECT AVG(stars) AS rate, mID as mvid FROM Rating as r
  				  GROUP BY mID
  				  HAVING rate >=4) AS tb1);
  				  
/*Q4: Remove all ratings where the movie's year is before 1970 or after 2000, and the rating is fewer than 4 stars. */
DELETE FROM rating
WHERE mID in (SELECT mID FROM movie WHERE YEAR <1970 OR YEAR > 2000)
AND stars < 4;
