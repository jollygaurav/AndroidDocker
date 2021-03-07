<h1>Docker Implementation and Setup on Appium for Android Applications </h1>

Download Docker from docker website. [If you installed desktop version you have to install docker-machine separately]

Install docker machine from here 

`
https://docs.docker.com/machine/install-machine/`

Make sure that you install the latest docker-machine version check by 

`docker-machine —version`

Download virtual box 

`https://www.virtualbox.org/wiki/Downloads`

Create a directory and clone appium docker android 

`git clone https://github.com/appium/appium-docker-android.git`

Jump to directory and run 

`docker build -t "appium/appium:local" -f Appium/Dockerfile Appium`

Identify docker version 

`docker-machine —version (if you are using docker cli) or get it from About Docker from Desktop App.`

Create a docker machine on Virtual Box 

`docker-machine create —driver virtualbox appium-test-machine `

Enable USB in created docker-machine 

`docker-machine stop appium-test-machine -> vboxmanage modifyvm appium-test-machine --usb on --usbehci on`

You need to install Extension Pack depends on your virtualbox version, in case you get an Error "Implementation of the USB 2.0 controller not found"

Open Virtual box, move to appium-test-machine created, select USB and add Android device and Host Controller.

Remove your base machine's ownership over the Android device(s)  

`adb kill-server`

SSH into the docker machine created  

`docker-machine ssh appium-test-machine`

Run the docker image on the newly created docker machine 

`docker run --privileged -d -p 4723:4723 -v /dev/bus/usb:/dev/bus/usb --name appiumContainer appium/appium`

Run following command to verify adb devices can detect the connected android device  

`docker exec -it appiumContainer adb devices`

Push the APK file to the container folder 

`docker cp /Users/LOCAL_PATH_TO_APK/APP_NAME.apk appiumContainer:/opt`

Now run your appium simply on the port assigned. Get the port IP using 

`docker-machine env appium-test-machine`

Add the IP Address as 

`driver =  new AndroidDriver(new URL("http://192.168.99.100:4723/wd/hub"),capabilities);`

Some useful commnds : 

`docker-machine start appium-test-machine` - to start the docker machine in VM

`docker-machine stop appium-test-machine` - to stop the docker machine in VM

`docker-machine env appium-test-machine` - to get the environment variables used at VM.

`docker-machine restart appium-test-machine` - to restart VM 

`eval $(docker-machine env default)` - set default environment variables for docker to find VM running

`docker-machine regenerate-certs` - to regenerate certificated for the machine

`docker logs appium --follow` - to follow the appium logs
