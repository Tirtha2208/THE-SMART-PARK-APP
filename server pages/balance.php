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

$cno=$_POST['cno'];

$i="SELECT *,COUNT(*) FROM register WHERE cno='$cno'";
if (mysqli_query($conn, $i)) {
    $rr=mysqli_query($conn,$i);
    $r=mysqli_fetch_array($rr);
    if($r['COUNT(*)']>=1)
    {
            $v=$r['balance'];
            
            echo "Your Current Balance is ".$v;
    }
    else
    {
        echo "Your account isn't register, kindly register first";
    }
}
else
{
    echo "Your account isn't register, kindly register first";
}
?>
