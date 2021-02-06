<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "smartpark";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

$email=$_POST['email'];
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$phoneno=$_POST['phone'];

$i=mysqli_query($conn,"SELECT COUNT(*) FROM register WHERE email='$email'");
$r=mysqli_fetch_array($i);

if($r['COUNT(*)'] >=1)
{
    echo 'Record is already present, kindly go for the booking';
}
else
{
    $sql = "INSERT INTO register (email,phone,fname,lname,registerdate)
    VALUES ('$email',$phoneno,'$fname','$lname',convert_tz(sysdate(),'+00:00','+05:30'))";
    if (mysqli_query($conn, $sql)) {
        $i=mysqli_query($conn,"SELECT * FROM register WHERE email='$email'");
        $r=mysqli_fetch_array($i);
        $v=$r['cid'];
        $i=($r['cid']*100);
         mysqli_query($conn,"UPDATE register SET cno='$fname$i' WHERE cid=$v");
      echo "Registration Successful, Please save this Customer ID : ".$fname.$i;
    } else {
      echo "Error : Operation didn't complete, Try Again";
    }
    
}

?>