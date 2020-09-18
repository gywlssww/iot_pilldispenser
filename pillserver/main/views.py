from django.shortcuts import render
from django.http import HttpResponse

from django.views import View
from django.http import JsonResponse
from .models import PrescriptionInfo

# Create your views here.
class index(View):
    def post(self,request):
        PrescriptionInfo(
            patiendID=request.POST['patientID'],
            pillname=request.POST['pillname'],
            pilldosage=request.POST['pilldosage'],
            userpw=request.POST['userpw'],
        ).save()
        print(pillname)
        return HttpResponse(status = 200)
    


  
def index(request):
    PrescriptionInfo(
            patientID=request.POST.get('patientid',"192.168.0.38"),
            pillname=request.POST.get('pillname',"타이레놀"),
            pilldosage=request.POST.get('pilldosage','1/1/1'),
            userpw=request.POST.get('userpw','9000'),
        ).save()
    
    return render(request,'main/index.html')
    #return HttpResponse("Hello World this is pill main server")
