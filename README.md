# Simple Golf Tournament System
My first Java programme, which I made for a module "Introduction to Object-Oriented Programming" during my first semester of University. 

A smiple golf tournament system uses the rules of normal golf, but each player's round is timed. It calculate the player's final adjusted time and declare the winner based on who has parred most of holes in the shortest final adjusted time. 

## Technology
<ul type="square">
<li>Java </li>
</ul>

## Goal and Requirements
Speed-golf uses the rules of normal golf, but each player's round is timed. A player's final adjusted time is the time taken to complete the course plus 1 minute for each shot taken. The lowest adjusted time is the winner.

<details>
<summary>Requirements</summary>
  <ul type="square">
<li> A tournament is played on a course. A course has a name and is made up of 18 holes (`course.txt`). Each hole has a par (the number of shots the hole is expected to take) usually between 3 and 5.</li>
<li> A tournament is played by a number of players. Each player has a unique name (can be considered to be a String of normal characters with no spaces). Each player is issued with a scorecard, onto which they enter the total time taken in minutes (to 1 decimal place) and the score for each hole. (`score.txt`)</li>
<li> At the end of the round, the system reads the scores from the scorecard. The system then provides a printout, showing the players performance on each hole, in terms of +/- compared to the par, and the final adjusted time for the round. </li>

  
<li> The player with the lowest net adjusted time is declared the winner.</li>
    
</ul>

Furthermore, `Controller.java`, a partial UML Class diagram, `course.txt`, and `score.txt` were already provided to me and did not require modification. 
  <p align="center">
  <img align="center" width="500" alt="UML class partial class diagram" src="https://user-images.githubusercontent.com/32418603/179777937-b7103a57-4b55-41ab-a51d-e1ba0777feb9.png">
  </p>
  <p align="center">Partial UML class diagram</p>


</details>

<details>
 <summary>Output</summary>
  <span>The output should match this layout</span>
 <img width="1023" alt="correct out of tournament" src="https://user-images.githubusercontent.com/32418603/179773431-cd7b92ab-c2c3-4d4a-b49d-a02eca761125.png">
  
</details>

## Key learning
- Define, create, and manipulate classes and objects using standard-object oriented programming concepts.
- Represent object models using standard notation.
- Solve small scale computing problems.

