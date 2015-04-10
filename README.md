-
-
-
# OpenCV with a few examples of Java. #

opencv version --> 2.4.10

# for netbeans #
-Select project, right click on "Properties".
-Select "Run" option, Change VM options to add native library 
  "-Djava.library.path="C:\opencv\build\java\x86" . 
-If you have a 32-bit system, you need to select the x86 folder instead of x64.

-
# using OpenCV, open video and red color detection in the video 
<a href="https://github.com/gurkan0791/Java-OpenCV-Example/tree/master/src/com/opencv/video">VideoCapture</a>

 for open video (mp4 etc.) add Path
 ;C:\opencv2.4.10\opencv\build\x64\vc12\bin;
 
 in Windows OS;
 
1) From the desktop, right-click My Computer and click Properties.
2) In the System Properties window, click on the Advanced tab.
3) In the Advanced section, click the Environment Variables button.
4) Finally, in the Environment Variables window (as shown below), highlight the Path variable in the Systems Variable section and click the Edit button. Add or modify the path lines with the paths you wish the computer to access. Each different directory is separated with a semicolon as shown below. Restart PC!

# usin OpenCV, Find differences between two pictures, video and picture..
<a href="https://github.com/gurkan0791/Java-OpenCV-Example/tree/master/src/opencv/fark">Here</a>
