# :pill: IoT_Pill Dispenser  :card_index:
Raspberry PI - IoT Pill dispenser (Object detection based on distributed computing) 


## 01. System Architecture

![최종설계2](https://user-images.githubusercontent.com/48641519/94326722-ecdec100-ffe0-11ea-8830-2a25b1c807e8.png)
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

 ### 1. How to
 
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

(1) install 3.5 touch screen

[driver to setup](https://github.com/waveshare/LCD-show)

(2) install pi-camera
   ```
     sudo raspi-config
     
     -> 5.Interfacing Options -> 1.Camera - Enabled  
   ``` 
   - to check the camera
   ```
    raspistill -o output.jpg
   ```
## 04. Application :iphone:
