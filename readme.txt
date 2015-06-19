

http://localhost:8080/claim/update
{
  "claimNumber": "22c9c23bac142856018ce14a26b6c299",
  "assignedAdjusterID": 12345,
  "exteriorColor": "Deep Impact Blue",
  "vin": "1M8GDM9AXKP042788",
  "licPlateExpDate": 1434290484700
}

http://localhost:8080/claim/create
{
  "claimNumber": "22c9c23bac142856018ce14a26b6c2993122345",
  "claimantFirstName": "George",
  "claimantLastName": "Washington",
  "status": "OPEN",
  "lossDate": 0,
  "lossInfo": {
    "causeOfLoss": "Hail",
    "lossDescription": "Crashed into an apple tree",
    "reportedDate": 1434290484700
  },
  "assignedAdjusterID": 12345,
  "vehicles": {
    "modelYear": 2015,
    "makeDescription": "Ford",
    "modelDescription": "Mustang",
    "engineDescription": "EcoBoost",
    "exteriorColor": "Deep Impact Blue",
    "vin": "1M8GDM9AXKP042788",
    "licPlate": "NO1PRES",
    "licPlateState": "VA",
    "licPlateExpDate": 1434290484700,
    "damageDescription": "Front end smashed in. Apple dents in roof",
    "mileage": 123
  }
}

http://localhost:8080/claim/find/22c9c23bac142856018ce14a26b6c2993122345
http://localhost:8080/claim/delete/22c9c23bac142856018ce14a26b6c2993122345
http://localhost:8080/claim/findall
http://localhost:8080/finddate?date=12-05-2013



