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

/*$email='tirthadeepb1999@yahoo.com';
$phoneno=1234567890;
$bikeno='WB 12x 3658';
$date='30-12-20';
$time='10:03';*/
$id=$_POST['id'];
$email=$_POST['email'];
$phoneno=$_POST['phone'];
$bikeno=$_POST['bikeno'];
$date=$_POST['date'];
$time=$_POST['time'];
$c=mysqli_query($conn,"SELECT COUNT(*) FROM recordbike WHERE status='Yes' and date_format(bookeddate,'%d/%m/%Y')='$date' and str_to_date(TIME(@booked_date),'%H:%i')>'$time'");
$rr=mysqli_fetch_array($c);
if($rr['COUNT(*)']<100)
{
    $ib=mysqli_query($conn,"SELECT * FROM register WHERE cno='$id'");
    $rb=mysqli_fetch_array($ib);
    if($rb['balance']>=10){
                $bal=$rb['balance']-10;
                $upd="UPDATE register SET balance=$bal WHERE cno='$id'";
   if (mysqli_query($conn, $upd)) {
            $sql = "INSERT INTO recordbike (cid,email,phone,bikeno,bookeddate,bookingdate)
            VALUES ('$id','$email',$phoneno,'$bikeno',str_to_date('$date $time','%d/%m/%Y %H:%i'),convert_tz(sysdate(),'+00:00','+05:30'))";
            
            
            
            if (mysqli_query($conn, $sql)) {
                $i=mysqli_query($conn,"SELECT * FROM recordbike WHERE email='$email' and date_format(bookeddate,'%d/%m/%Y')='$date' and date_format(bookeddate,'%H:%i')='$time' and bikeno='$bikeno'");
                $r=mysqli_fetch_array($i);
                $i=$r['id']+43000105;
              echo "New record created successfully, save this id for exit : ".$i;
            } else {
              echo "Error : Operation didn't complete, Try Again";
            }
   }
    }
   else
   {
       echo "You are short of balance, please recharge your wallet and try again";
   }
}
else
{
    echo "Parking lot is already full in this time slot";
}

mysqli_close($conn);
?>