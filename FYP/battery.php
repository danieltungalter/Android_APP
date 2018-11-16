<?php

$host='127.0.0.1';
$username='root';
$pwd='';
$db="recycling_info";

$con=mysqli_connect($host,$username,$pwd,$db) or die('Unable to connect');

if(mysqli_connect_error($con))
{
  echo "Failed to Connect to Database ".mysqli_connect_error();
}



$sql="SELECT c.company,c.contact_person,c.address,c.tel_no,c.email,c.description,
 t.type , p.weight, p.price
FROM cust_info c
INNER JOIN price p
    on c.cust_id = p.cust_id
INNER JOIN category t
    on p.cate_id = t.cate_id
WHERE t.type = 'battery'
ORDER BY p.price DESC";

$query=mysqli_query($con,$sql);

if($query)
{
    while($row=mysqli_fetch_array($query))
  {
    $data[]=$row;
  }

    print(json_encode($data));

}else
{
  echo('Not Found ');
}
mysqli_close($con);

?>