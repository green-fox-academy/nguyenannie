/*Q1: Find the titles of all movies directed by Steven Spielberg. */

SELECT title FROM Movie
    WHERE director = "Steven Spielberg";

/*Q2: Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order. */

SELECT DISTINCT year FROM Movie
    INNER JOIN Rating ON Movie.mID = Rating.mID
    WHERE stars >= 4
    ORDER BY year ASC;

/*Q3: Find the titles of all movies that have no ratings. */

SELECT title FROM Movie
    LEFT JOIN Rating ON Movie.mID = Rating.mID
    WHERE stars IS NULL;

/*Q4: Some reviewers didn't provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date. */

SELECT name FROM Reviewer
    LEFT JOIN Rating ON Reviewer.rID = Rating.rID
    WHERE ratingDate IS NULL;

/*Q5: Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars. */

SELECT Reviewer.name, Movie.title, Rating.stars, Rating.ratingDate FROM Rating
    JOIN Reviewer ON Rating.rID = Reviewer.rID
    JOIN Movie ON Rating.mID = Movie.mID
    ORDER BY Reviewer.name, Movie.title, Rating.stars;

/*Q6: For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time, return the reviewer's name and the title of the movie.*/

SELECT Reviewer.name, Movie.title
	FROM Rating as r1 
	JOIN Rating as r2 ON r1.rID = r2.rId
	JOIN Reviewer ON r1.rID = Reviewer.rID
	JOIN Movie ON r2.mID = Movie.mID
	WHERE r1.mId = r2.mId and r1.ratingDate < r2.ratingDate and r1.stars < r2.stars;

/*Q7: For each movie that has at least one rating, find the highest number of stars that movie received. Return the movie title and number of stars. Sort by movie title.*/

SELECT Movie.title, MAX(stars)
	FROM Rating AS rate
	JOIN Reviewer ON rate.rID = Reviewer.rID
	JOIN Movie ON rate.mID = Movie.mID
	GROUP BY Movie.title;

/*Q8: For each movie, return the title and the 'rating spread', that is, the difference between highest and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.*/	

SELECT Movie.title, MAX(stars) - MIN(stars) AS rating_speed
	FROM Rating AS rate
	JOIN Reviewer ON rate.rID = Reviewer.rID
	JOIN Movie ON rate.mID = Movie.mID
	GROUP BY Movie.title
	ORDER BY rating_speed DESC, Movie.title ASC;

/*Q9: Find the difference between the average rating of movies released before 1980 and the average rating of movies released after 1980. (Make sure to calculate the average rating for each movie, then the average of those averages for movies before 1980 and movies after. Don't just calculate the overall average rating before and after 1980.) */	

SELECT (average_bf80.rate_A - average_af80.rate_B) as finalResult FROM
	(SELECT AVG(avg_rating) as rate_A FROM (
		SELECT Movie.year, AVG(stars) AS avg_rating
			FROM Rating AS rate
			JOIN Movie ON rate.mID = Movie.mID
			GROUP BY Movie.year) AS average_bf80
		WHERE average_bf80.year < 1980) AS average_bf80
	JOIN 
	(SELECT AVG(avg_rating) as rate_B FROM (
		SELECT Movie.year, AVG(stars) AS avg_rating
			FROM Rating AS rate
			JOIN Reviewer ON rate.rID = Reviewer.rID
			JOIN Movie ON rate.mID = Movie.mID
			GROUP BY Movie.year) AS average_af80
		WHERE average_af80.year > 1980) AS average_af80;

/*---------------------------------------------------------------------------------------------------*/		

/*Q1: Find the names of all reviewers who rated Gone with the Wind. */

SELECT DISTINCT Reviewer.name FROM Rating
	JOIN Reviewer ON Rating.rID = Reviewer.rID
	JOIN Movie ON Movie.mID = Rating.mID
	WHERE Movie.title = "Gone with the Wind" AND Rating.stars IS NOT NULL;

/*Q2: For any rating where the reviewer is the same as the director of the movie, return the reviewer name, movie title, and number of stars.*/

SELECT Reviewer.name, Movie.title, stars FROM Rating
	JOIN Reviewer ON Rating.rID = Reviewer.rID
	JOIN Movie ON Rating.mID = Movie.mID
	WHERE Reviewer.name = Movie.director;
	
/*Q3: Return all reviewer names and movie names together in a single list, alphabetized. (Sorting by the first name of the reviewer and first word in the title is fine; no need for special processing on last names or removing "The".)*/

SELECT DISTINCT Reviewer.name FROM Reviewer 
UNION 
SELECT DISTINCT title FROM Movie
ORDER BY name;

/*Q4: Find the titles of all movies not reviewed by Chris Jackson. */

SELECT Movie.title as title FROM Movie
	WHERE Movie.title NOT IN (
		SELECT Movie.title as title FROM Rating
		INNER JOIN Reviewer ON Rating.rID = Reviewer.rID
		INNER JOIN Movie ON Rating.mID = Movie.mID
		WHERE Reviewer.name = "Chris Jackson") ;

/*Q5: For all pairs of reviewers such that both reviewers gave a rating to the same movie, return the names of both reviewers. Eliminate duplicates, don't pair reviewers with themselves, and include each pair only once. For each pair, return the names in the pair in alphabetical order.
SELECT Movie.title, Reviewer.name FROM Rating
	JOIN Reviewer ON Rating.rID = Reviewer.rID
	JOIN Movie ON Rating.mID = Movie.mID
	GROUP BY Movie.title, Reviewer.name;
	*/
	
SELECT DISTINCT re1.name, re2.name FROM Rating AS r1
JOIN Rating AS r2 ON r1.mID = r2.mID
JOIN Reviewer AS re1 ON r1.rID = re1.rID
JOIN Reviewer AS re2 ON r2.rID = re2.rID
WHERE re1.name < re2.name
ORDER BY re1.name ASC;
	
/*Q6: For each rating that is the lowest (fewest stars) currently in the database, return the reviewer name, movie title, and number of stars.*/

SELECT Reviewer.name, Movie.title, Rating.stars FROM Rating
	JOIN Reviewer ON Rating.rID = Reviewer.rID
	JOIN Movie ON Rating.mID = Movie.mID
	WHERE Rating.stars = (SELECT MIN(Rating.stars) FROM Rating);

/*Q7: List movie titles and average ratings, from highest-rated to lowest-rated. If two or more movies have the same average rating, list them in alphabetical order.*/

SELECT Movie.title, AVG(stars) AS avg_rating
		FROM Rating AS rate
		JOIN Movie ON rate.mID = Movie.mID
		GROUP BY Movie.title
		ORDER BY avg_rating DESC, Movie.title ASC;
		
/*Q8: Find the names of all reviewers who have contributed three or more ratings. (As an extra challenge, try writing the query without HAVING or without COUNT.) */

SELECT Reviewer.name FROM Rating
	JOIN Reviewer ON Rating.rID = Reviewer.rID
	JOIN Movie ON Rating.mID = Movie.mID;
	GROUP BY Reviewer.rID
	HAVING COUNT(Reviewer.name) >= 3;
	
/*Q9: Some directors directed more than one movie. For all such directors, return the titles of all movies directed by them, along with the director name. Sort by director name, then movie title. (As an extra challenge, try writing the query both with and without COUNT.) */

SELECT title, director FROM Movie
WHERE director = 
(SELECT director FROM Movie
GROUP BY director
HAVING COUNT(director) >= 2
LIMIT 1) OR director = 
(SELECT director FROM Movie
GROUP BY director
HAVING COUNT(director) >= 2
LIMIT 1 OFFSET 1)
ORDER BY director, title;

/*Find the movie(s) with the highest average rating. Return the movie title(s) and average rating. (Hint: This query is more difficult to write in SQLite than other systems; you might think of it as finding the highest average rating and then choosing the movie(s) with that average rating.) */

SELECT a.t, a.avg_rating FROM (
	SELECT Movie.title as t, AVG(stars) AS avg_rating
			FROM Rating AS rate
			JOIN Movie ON rate.mID = Movie.mID
			GROUP BY Movie.title) AS a
			WHERE a.avg_rating = 
				(SELECT MAX(a.avg_rating) FROM 
				(SELECT AVG(stars) AS avg_rating
				FROM Rating AS rate
				JOIN Movie ON rate.mID = Movie.mID
				GROUP BY Movie.title) AS a);

/*Q11: Find the movie(s) with the lowest average rating. Return the movie title(s) and average rating. (Hint: This query is more difficult to write in SQLite than other systems; you might think of it as finding the highest average rating and then choosing the movie(s) with that average rating.) */

SELECT a.t, a.avg_rating FROM (
	SELECT Movie.title as t, AVG(stars) AS avg_rating
			FROM Rating AS rate
			JOIN Movie ON rate.mID = Movie.mID
			GROUP BY Movie.title) AS a
			WHERE a.avg_rating = 
				(SELECT MIN(a.avg_rating) FROM 
				(SELECT AVG(stars) AS avg_rating
				FROM Rating AS rate
				JOIN Movie ON rate.mID = Movie.mID
				GROUP BY Movie.title) AS a);

/*Q12: For each director, return the director's name together with the title(s) of the movie(s) they directed that received the highest rating among all of their movies, and the value of that rating. Ignore movies whose director is NULL. */

SELECT DISTINCT Movie.director, Movie.title, MAX(Rating.stars) FROM Movie
	LEFT JOIN Rating ON Movie.mID = Rating.mID
	WHERE Movie.director IS NOT NULL AND Rating.stars IS NOT NULL
	GROUP BY Movie.director
    ORDER BY Movie.director ASC;


	

