<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="icon" href="resources/favicon.jpg">
<link rel="stylesheet" href="css/commons.css">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="vertical-menu">
	  <a href="index.jsp" class="active">Home</a>
	  <%if(session.getAttribute("role")==null){%>
	  		<a href="pages/login.jsp" >Login</a>
            <a href="pages/register.jsp">Registration</a>
	  <%}if(session.getAttribute("role")!=null){%>
		    <a href="#">User Profile</a>
	  	<%if(session.getAttribute("role").toString().equals("professor")){%>
			<a href="pages/Professor/grading.jsp">Grading</a>
			<a href="pages/Professor/showCourses.jsp">Grade list by course</a>
	  	<%}else if(session.getAttribute("role").toString().equals("secretary")){%>
		    <a href="pages/Secretary/allcourses.jsp">Courses</a>
	  		<a href="pages/Secretary/courseProf.jsp">Teaching staff per course</a>
	  		<a href="pages/Secretary/assignment.jsp">Course and Professor Management</a>
	    <%}else if(session.getAttribute("role").toString().equals("student")){%>
    	    <a href="pages/Student/courseGrade.jsp">Course grades</a>
  			<a href="pages/Student/semesterGrade.jsp">Semester grades</a>
  			<a href="pages/Student/totalGrade.jsp">Total grades</a>
	  	<%}}%>
  	  <a href="pages/contact.jsp">Contact</a>
	  <%if(session.getAttribute("username")!=null){%>
	  <form id="logout" action="LogoutServlet" method="POST">
	  	<a href="#" onclick="document.getElementById('logout').submit();" class="logout"> Logout </a>
	  </form>
	  <%}%>
	</div>
	<div style="margin-left:200px;">
		<div class="landing">
				<div style="overflow:auto">
    				<img src="resources/logo.jpg" style="max-width:200px;max-height:200px;float:left;" alt="logo">
				<h1 class=label style="display:inline-block;margin-top:55px;width:70%;">Welcome to the VKAD User Authentication Platform (2022)</h1> 
  				</div>
				<br>
				<div class="info">
			           <p>VKAD, the University's web portal, is available to applicants, students, staff, visitors and alumni. You can login to VKAD using your University Login Credentials <a href="pages/login.jsp" style="text-decoration: none;color:#2FA5C8">here</a>.</p>
				   <p>If you haven't created an account yet, <a href="pages/register.jsp" style="text-decoration: none;color:#2FA5C8">click here </a>to set up your University Login.</p>
				   <h2>Through VKAD you will be able to:</h2>
					<ul>
    					  <li>As a student, view registered grades, by class or semester.</li>
    					  <li>As a professor, view a detailed list of graded courses, and grade pending ones.</li>
    					  <li>Secretary functions: view course info and assign a professor to it.</li>
     					  <li>Catch up on recent news and announcements.
    					  <li>Find contact information of university members and personnel.
  					</ul>
				</div>
				<br>
				<article class="scroller">
					<h1 class=label>Νέα και Ανακοινώσεις</h1>
				    <section>
				        <h2>Ανακοίνωση για την εξεταστική Ιουνίου - Ιουλίου 2022</h2>
				        <p>
				        Σχετικά με τα 
						έκτακτα μέτρα προστασίας της δημόσιας υγείας από τον κίνδυνο περαιτέρω διασποράς του 
						κορωνοϊού COVID-19, κατά την περίοδο της εξεταστικής περιόδου Ιουνίου - Ιουλίου του 
						ακαδημαϊκού έτους 2021-2022 εφαρμόζονται τα εξής:<br><br>
						Α) Η χρήση προστατευτικής μάσκας είναι <b>υποχρεωτική</b> σε όλους τους χώρους του 
						Πανεπιστημίου (ενδεικτικά αίθουσες, αμφιθέατρα, εργαστήρια) εντός των οποίων 
						διεξάγονται κάθε είδους εξετάσεις για όλα ανεξαιρέτως τα πρόσωπα που εισέρχονται σε 
						αυτούς (φοιτητές, υποψηφίους, μέλη ΔΕΠ, επιτηρητές, λοιπό προσωπικό).<br>
						Β) Κατά την εξεταστική του εαρινού εξαμήνου υπάρχει πιθανότητα φοιτητές που 
						συμμετέχουν στις εξετάσεις, να νοσήσουν με λοίμωξη την ημέρα της εξεταστικής και να μην 
						μπορούν να συμμετέχουν για όσο χρονικό διάστημα βρίσκονται στην απομόνωση, σύμφωνα 
						με το εκάστοτε ισχύον υγειονομικό πρωτόκολλο απομόνωσης. Οι συγκεκριμένοι φοιτητές θα 
						εξεταστούν στα μαθήματα στα οποία υποχρεωτικώς απουσίαζαν, σε άλλη ημερομηνία που 
						θα οριστεί με επιμέλεια του διδάσκοντος.
				        </p>
				    </section>
				    <hr>
				    <section>
				        <h2>Ανακοίνωση Προγράμματος Χορήγησης Υποτροφιών για Μaster 2 στη Γαλλία, ακαδ.έτους 2022-2023</h2>
				        <p>
				        Το Ίδρυμα Κρατικών Υποτροφιών (ΙΚΥ) –ως Εθνικός Φορέας Υποτροφιών- και το Γαλλικό Ινστιτούτο 
						Ελλάδος (IFG) -ως Υπηρεσία Συνεργασίας και Μορφωτικής Δράσης της Πρεσβείας της Γαλλίας, στο πλαίσιο 
						των διαθέσιμων πιστώσεων του προγράμματος «<em>Υποτροφίες Ελληνο-Γαλλικής Συνεργασίας</em>», χορηγούν 
						ετησίως, από κοινού, υποτροφίες. <br>
						Για το ακαδημαϊκό έτος 2022-2023, προκηρύσσουν <b>τριάντα-έξι (36) υποτροφίες διάρκειας (10) δέκα 
						μηνών</b> για μεταπτυχιακές σπουδές, (επιπέδου Master 2), σε δημόσιο Πανεπιστημιακό Ίδρυμα Ανώτατης 
						Εκπαίδευσης στην Γαλλία, ανεξαρτήτως επιστημονικού τομέα. <ins>Δεν είναι επιλέξιμα τα Προγράμματα 
						Μεταπτυχιακών Σπουδών (ΠΜΣ) που υλοποιούνται εξ αποστάσεως, όταν ο υποψήφιος υποβάλει την 
						αίτησή του, καθώς και τα εκπαιδευτικά προγράμματα ΜΒΑ</ins>.<br><br>
						Η πρόσκληση υποβολής υποψηφιοτήτων για το έτος 2022-2023 ξεκινάει στις <b>09/06/2022</b> και λήγει την
						<b>01/07/2022 και ώρα Eλλάδος 23:00</b>.
				        </p>
				    </section>
				    <hr>
				    <section>
				        <h2>ΔΙΟΡΘΩΣΕΙΣ - Πρόγραμμα Εξεταστικής Εαρινού Εξαμήνου Ακαδ. Έτους 2021-2022</h2>
					<p>ΕΝΗΜΕΡΩΝΟΥΜΕ ΤΟΥΣ ΦΟΙΤΗΤΕΣ/ΤΡΙΕΣ ΟΤΙ ΕΓΙΝΑΝ ΟΙ ΠΑΡΑΚΑΤΩ ΔΙΟΡΘΩΣΕΙΣ ΣΤΟ ΠΡΟΓΡΑΜΜΑ ΕΞΕΤΑΣΤΙΚΗΣ ΚΑΤΟΠΙΝ ΠΡΟΒΛΗΜΑΤΟΣ ΠΟΥ ΔΗΜΙΟΥΡΓΗΘΗΚΕ ΜΕ ΑΙΘΟΥΣΕΣ ΤΗΝ ΠΑΡΑΣΚΕΥΗ 11/07/2022 ΛΟΓΩ ΣΥΝΕΔΡΙΟΥ
					<br><br>09-10 Μάρκετινγκ Χρημ. Υπηρεσιών (Ν. Καταραχιά) η εξέταση θα γίνει στην 204.
					<br><br>10-11 Κοινωνική Οικονομία & Συνεταιριστική Επιχ. (Ν. Καταραχιά) η εξέταση θα γίνει στην 203.
					<br><br>11-12 Σύγχρονες Μορφές Χρηματοδότησης (Γ. Κυριαζόπουλος) η εξέταση θα γίνει στο γραφείο του καθηγητή.
					<br><br>12-13 Διεθνείς Χρηματ. Αγορές (Γ. Κυριαζόπουλος) η εξέταση θα γίνει στο γραφείο του καθηγητή.
					<br><br>14-15 Αποτίμηση Επιχειρήσεων (Γ. Κυριαζόπουλος) η εξέταση θα γίνει στο Μεγάλο Αμφιθέατρο με έναρξη 14.00 (όχι 13.00 όπως ήταν στο αρχικό πρόγραμμα).
					<br>
					<p style="margin-bottom:0;"> Κατεβάστε το νέο πρόγραμμα</p>
					<a href="https://www.cs.unipi.gr/index.php?option=com_k2&view=item&task=download&id=608_58de5fc9395b3fde69a938347847dee6&Itemid=673&lang=el" download>
  						<img src="https://media.istockphoto.com/vectors/download-button-vector-icon-vector-id931778082?k=20&m=931778082&s=612x612&w=0&h=5CQAdq8PGCKIEZXNGb-IS5fiBEB-TxSqYlR9Wj2HHnI=" alt="download" width="25" height="25" style="display:inline-block">
					</a>
				    </section>
				</article>
			<div class="calendar">
				<div class="month">      
				  <ul>
				    <li>
				      July<br>
				      <span style="font-size:18px">2022</span>
				    </li>
				  </ul>
				</div>
				
				<ul class="weekdays">
				  <li>Mo</li>
				  <li>Tu</li>
				  <li>We</li>
				  <li>Th</li>
				  <li>Fr</li>
				  <li>Sa</li>
				  <li>Su</li>
				</ul>
				
				<ul class="days">  
				  <li>1</li>
				  <li>2</li>
				  <li>3</li>
				  <li>4</li>
				  <li>5</li>
				  <li>6</li>
				  <li>7</li>
				  <li>8</li>
				  <li>9</li>
				  <li><span class="active">10</span></li>
				  <li>11</li>
				  <li>12</li>
				  <li>13</li>
				  <li>14</li>
				  <li>15</li>
				  <li>16</li>
				  <li>17</li>
				  <li>18</li>
				  <li>19</li>
				  <li>20</li>
				  <li>21</li>
				  <li>22</li>
				  <li>23</li>
				  <li>24</li>
				  <li>25</li>
				  <li>26</li>
				  <li>27</li>
				  <li>28</li>
				  <li>29</li>
				  <li>30</li>
				  <li>31</li>
				</ul>
		    </div>
		</div>
	</div>
</body>
</html>