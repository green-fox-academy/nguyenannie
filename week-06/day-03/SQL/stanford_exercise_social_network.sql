/*Q1: Find the names of all students who are friends with someone named Gabriel. */
SELECT Highschooler.name FROM Highschooler
	WHERE Highschooler.ID IN (
		SELECT Friend.ID2 FROM Highschooler
		JOIN Friend ON Friend.ID1 = Highschooler.ID
		WHERE Highschooler.name = "Gabriel");

/*Q2: For every student who likes someone 2 or more grades younger than themselves, return that student's name and grade, and the name and grade of the student they like.*/
SELECT Hs1.name, Hs1.grade, Hs2.name, Hs2.grade FROM Highschooler AS Hs1
	LEFT JOIN Likes AS l1 ON Hs1.ID = l1.ID1
	LEFT JOIN Highschooler AS Hs2 ON Hs2.ID = l1.ID2
	WHERE Hs1.grade - Hs2.grade >= 2;
	
/*Q3: For every pair of students who both like each other, return the name and grade of both students. Include each pair only once, with the two names in alphabetical order. */
SELECT Hs1.name, Hs1.grade, Hs2.name, Hs2.grade FROM Highschooler AS Hs1
	LEFT JOIN Likes AS l1 ON Hs1.ID = l1.ID1
	LEFT JOIN Highschooler AS Hs2 ON Hs2.ID = l1.ID2
	WHERE Hs1.ID IN 
	(SELECT ID2 FROM Likes) AND
	Hs2.ID IN 
	(SELECT ID1 FROM Likes) AND Hs1.name < Hs2.name
	ORDER BY Hs1.name;

/*Q4: Find all students who do not appear in the Likes table (as a student who likes or is liked) and return their names and grades. Sort by grade, then by name within each grade.*/
SELECT Hs1.name, Hs1.grade FROM Highschooler AS Hs1
	LEFT JOIN Likes AS l1 ON Hs1.ID = l1.ID1
	WHERE Hs1.ID NOT IN (
	SELECT ID1 FROM Likes) AND
	Hs1.ID NOT IN (
	SELECT ID2 FROM Likes)
	ORDER BY Hs1.grade, Hs1.name;
/*Q5: For every situation where student A likes student B, but we have no information about whom B likes (that is, B does not appear as an ID1 in the Likes table), return A and B's names and grades. */
SELECT Hs1.name, Hs1.grade, Hs2.name, Hs2.grade FROM Highschooler AS Hs1
	LEFT JOIN Likes AS l1 ON Hs1.ID = l1.ID1
	LEFT JOIN Highschooler AS Hs2 ON Hs2.ID = l1.ID2
	WHERE Hs2.ID NOT IN (
	SELECT ID1 FROM Likes);

/*Q6: Find names and grades of students who only have friends in the same grade. Return the result sorted by grade, then by name within each grade.*/
SELECT Highschooler.name, Highschooler.grade FROM Highschooler 
	WHERE Highschooler.ID NOT IN (
		SELECT Hs1.ID FROM Highschooler AS Hs1
		LEFT JOIN Friend AS Fr ON Hs1.ID = Fr.ID1
		LEFT JOIN Highschooler AS Hs2 ON Hs2.ID = Fr.ID2
		WHERE Hs1.grade != Hs2.grade)
	ORDER BY Highschooler.grade, Highschooler.name;
	
/*Q7: For each student A who likes a student B where the two are not friends, find if they have a riend C in common (who can introduce them!). For all such trios, return the name and grade of A, B, and C. */
SELECT Hs1.name, Hs1.grade, Hs2.name, Hs2.grade, Hs3.name, Hs3.grade FROM Likes AS Lk
	LEFT JOIN Highschooler AS Hs1 ON Lk.ID1 = Hs1.ID
	LEFT JOIN Highschooler AS Hs2 ON Lk.ID2 = Hs2.ID
	LEFT JOIN Friend AS Fr1 ON Fr1.ID1 = Hs1.ID
	LEFT JOIN Friend AS Fr2 ON Fr2.ID2 = Hs2.ID
	LEFT JOIN Highschooler AS Hs3 ON Fr1.ID2 = Hs3.ID
	WHERE Hs2.ID NOT IN (SELECT ID2 FROM Friend WHERE ID1 = Hs1.ID) AND Hs3.ID = Fr2.ID1;

/*Q8: Find the difference between the number of students in the school and the number of different first names. */
SELECT ((SELECT COUNT(Highschooler.name) FROM Highschooler) - (SELECT COUNT(diff_name.hsn) AS c FROM (SELECT DISTINCT Highschooler.name AS hsn FROM Highschooler) AS diff_name)) AS diff_hsn;

/*Q9: Find the name and grade of all students who are liked by more than one other student. */
SELECT Hs2.name, Hs2.grade FROM Highschooler AS Hs1
	LEFT JOIN Likes AS Lk ON Hs1.ID = Lk.ID1
	JOIN Highschooler AS Hs2 ON Hs2.ID = Lk.ID2
	GROUP BY Lk.ID2
    HAVING COUNT(Lk.ID2) >= 2
    ORDER BY Hs2.name;
    
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/

/*Q1: For every situation where student A likes student B, but student B likes a different student C, return the names and grades of A, B, and C. */
SELECT Hs1.name, Hs1.grade, Hs2.name, Hs2.grade, Hs3.name, Hs3.grade FROM Likes AS Lk1
	LEFT JOIN Likes AS Lk2 ON Lk1.ID2 = Lk2.ID1
	LEFT JOIN Highschooler AS Hs1 ON Lk1.ID1 = Hs1.ID
	LEFT JOIN Highschooler AS Hs2 ON Lk2.ID1 = Hs2.ID
	LEFT JOIN Highschooler AS Hs3 ON Lk2.ID2 = Hs3.ID
	WHERE Lk1.ID1 > Lk2.ID2;

/*Q2: Find those students for whom all of their friends are in different grades from themselves. Return the students' names and grades*/
SELECT Hs.name, Hs.grade FROM Highschooler as Hs
WHERE Hs.ID NOT IN (SELECT friend_same_grade.hs1_id FROM
(SELECT Hs1.ID as hs1_id, Hs2.ID as hs2_id FROM Friend AS Fr
	LEFT JOIN Highschooler AS Hs1 ON Fr.ID1 = Hs1.ID
	LEFT JOIN Highschooler AS Hs2 ON Fr.ID2 = Hs2.ID
	WHERE Hs1.ID > Hs2.ID AND Hs1.grade = Hs2.grade) AS friend_same_grade) AND Hs.ID NOT IN (SELECT friend_same_grade.hs2_id FROM
(SELECT Hs1.ID as hs1_id, Hs2.ID as hs2_id FROM Friend AS Fr
	LEFT JOIN Highschooler AS Hs1 ON Fr.ID1 = Hs1.ID
	LEFT JOIN Highschooler AS Hs2 ON Fr.ID2 = Hs2.ID
	WHERE Hs1.ID > Hs2.ID AND Hs1.grade = Hs2.grade) AS friend_same_grade);
	
/*What is the average number of friends per student? (Your result should be just one number.) */
SELECT AVG(friend_num.fr_count) FROM 
	(SELECT ID1, COUNT(ID2) AS fr_count FROM Friend
	GROUP BY ID1) AS friend_num;
	
/*Find the number of students who are either friends with Cassandra or are friends of friends of Cassandra. Do not count Cassandra, even though technically she is a friend of a friend. */
SELECT COUNT(ID2) FROM Friend 
	WHERE ID2 IN (SELECT tb.b FROM
		(SELECT Hs1.ID as a, Hs2.ID as b FROM Friend AS Fr
		JOIN Highschooler AS Hs1 ON Fr.ID1 = Hs1.ID
		JOIN Highschooler AS Hs2 ON Fr.ID2 = Hs2.ID
		WHERE Hs1.name = "Cassandra") as tb);
		
/*Find the name and grade of the student(s) with the greatest number of friends. */
SELECT DISTINCT Hs.name, Hs.grade FROM Highschooler AS Hs
    JOIN Friend AS Fr ON Fr.ID1 = Hs.ID
    WHERE Hs.ID IN (SELECT tb1.st 
                    FROM (SELECT ID1 as st, COUNT(ID2) AS c 
                          FROM Friend
                          GROUP BY ID1) AS tb1
                    WHERE c = (SELECT MAX(tb.c) 
                               FROM (SELECT ID1 as st, COUNT(ID2) AS c 
                               FROM Friend
                               GROUP BY st) AS tb));