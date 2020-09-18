from django.db import models

# Create your models here.
class PrescriptionInfo(models.Model):
    patientID=models.CharField(max_length=30)
    pillname=models.CharField(max_length=30)
    pilldosage=models.CharField(max_length=100)
    userpw=models.CharField(max_length=10)

    def __str__(self):
        return self.patientID
