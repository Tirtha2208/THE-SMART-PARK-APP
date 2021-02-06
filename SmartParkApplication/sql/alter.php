<?php
$servername = "localhost";
$username = "id15675975_record_park";
$password = "Majester_smartpark123456";
$dbname = "id15675975_record";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
$email=$_POST['email'];
$id=$_POST['id'];
$type=$_POST['type'];
if($type=='car' or $type=='CAR' or $type=='Car' ){
    $upd=($id-9250026)/100;
    $sqlc="UPDATE recordcar SET status='No',leavingdate=convert_tz(sysdate(),'+00:00','+05:30') WHERE id=$upd and email='$email'";
    if (mysqli_query($conn, $sqlc)) {
        echo "Thank you, now the Lot is free...Visit Again";
    }
    else
    {
        echo "Error: " . $sqlc . "<br>" . mysqli_error($conn);
    }
}
else if($type=='bike' or $type=='BIKE' or $type=='Bike' )
{
    $r=$id-43000105;
    $sqlb="UPDATE recordbike SET status='No',leavingdate=convert_tz(sysdate(),'+00:00','+05:30') WHERE id=$r and email='$email'";
    if (mysqli_query($conn, $sqlb)) {
        echo "Thank you, now the Lot is free...Visit Again";
    }
    else
    {
        echo "Error: " . $sqlb . "<br>" . mysqli_error($conn);
    } 
}
?>