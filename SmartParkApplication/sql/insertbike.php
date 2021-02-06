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

/*$email='tirthadeepb1999@yahoo.com';
$phoneno=1234567890;
$bikeno='WB 12x 3658';
$date='30-12-20';
$time='10:03';*/

$email=$_POST['email'];
$phoneno=$_POST['phone'];
$bikeno=$_POST['bikeno'];
$date=$_POST['date'];
$time=$_POST['time'];
$c=mysqli_query($conn,"SELECT COUNT(*) FROM recordbike WHERE status='Yes' and date_format(bookeddate,'%d-%m-%y')='$date' and str_to_date(TIME(@booked_date),'%H:%i')>'$time'");
$rr=mysqli_fetch_array($c);
if($rr['COUNT(*)']<100)
{

    $sql = "INSERT INTO recordbike (email,phone,bikeno,bookeddate,bookingdate)
    VALUES ('$email',$phoneno,'$bikeno',str_to_date('$date $time','%d-%m-%y %H:%i'),convert_tz(sysdate(),'+00:00','+05:30'))";
    
    
    
    if (mysqli_query($conn, $sql)) {
        $i=mysqli_query($conn,"SELECT * FROM recordbike WHERE email='$email' and date_format(bookeddate,'%d-%m-%y')='$date' and date_format(bookeddate,'%H:%i')='$time' and bikeno='$bikeno'");
        $r=mysqli_fetch_array($i);
        $i=$r['id']+43000105;
      echo "New record created successfully, save this id for exit : ".$i;
    } else {
      echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
}
else
{
    echo "Parking lot is already full in this time slot";
}

mysqli_close($conn);
?>