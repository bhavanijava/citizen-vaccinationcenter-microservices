# citizen-vaccinationcenter-microservices-part1
Citizen-Service
---------------
```bhavani
URL:-http://localhost:8001/citizen/add
http method: POST
```
Json Request:
```bhavani
{
    "name":"person-1",
    "vaccinationCenterId":2001
}
```
Json Response:
```bhavani
{
    "id": 61,
    "name": "person-1",
    "vaccinationCenterId": 2001
}
```
Vaccination-Center
-----------------
```bhavani
Json Request:
```bhavani
{
    "id":2001,
    "centerName":"center-1",
    "centerAddress":"hyderabad"
}
```
Json Response:
```bhavani
{
    "id": 2001,
    "centerName": "center-1",
    "centerAddress": "hyderabad"
}
```



