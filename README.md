# :pill: IoT_Pill Dispenser  :card_index:
Raspberry PI - IoT Pill dispenser (Object detection based on distributed computing) 


## 01. System Architecture

 1. Server  (Docker, Django) 
- Remote prescription system for Immunosuppressant / Thrombocoagulant
- Postgresql Presciption DB

 2. Device (Raspberry Pi, k3s) 
 - Pill-image Object detection based on Fast R-CNN
 - k3s cluster - 1 master + 3 slaves

 3. Mobile Application 
 - Pill Storage/Dosage Management
 - Mapping storage of each pill & prescription 

## 02. Server :hospital:

 1. How to
 (1) Install Docker
 (2) Clone the repository
 (3) Start the server
    ```
    docker-compose up --build
    ```
 (4) Connect to 
    ```
    localhost:8000/main (insert new info)
     ```
    ```
    localhost:8000/admin (view data)
    ```
## 03. Raspberry Pi Device  :house:
## 04. Application :iphone:
