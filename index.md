# ALOImagePro - ImageJ plugin
## A useful ImageJ plugin for image processing using the basic arithmetic and logic operations implemented in ImageJ  
---

Scientific Publication: 
[Link to the publication](https://www.researchgate.net/publication/349213848_APPLICATION_OF_ARITHMETIC_AND_LOGIC_OPERATIONS_FOR_OBJECTS_EXTRACTION_IN_IMAGEJ).

# Plugin Introduction
Arithmetic and logic operations are simple images processing operations which involve two or more images. There are a lot of applications of arithmetic and logic operations such as motion detection, objects extraction and etc. ALOImagePro (Arithmetic Logical Operations for Images Processing) application is developed as Java plugin for the open-source software ImageJ. The plugin has one main window which contains one or twelve images which are results of arithmetic and logic operations performed on two images, selected by the user. The plugin is useful for easy testing of arithmetic and logic operations.
   
# User guide

## Plugin Instalation

1. [Download](https://github.com/AngelDanev/uft-cst.github.io) the ALOImagePro_.java file and save it on your PC. 
2. Open ImageJ program, select Plugins menu and click on the Install... option.
3. An "Install Plugin, Macro and Script..." window opened. 
4. Browse to the folder in which ALOImagePro_.java is saved.
5. Select the file and click "Open". Another window appears, click "Save".
6. The plugin ALOImagePro is now inatalled and ready to use.

## Plugin Interface and Usage
The graphical user interface of the plugin is shown on the image below.

![image](https://user-images.githubusercontent.com/86291178/123095676-fba2b900-d436-11eb-84f0-e4e4f32db950.png)

The main window of the plugin contains several elements: 
*	Choice button - it contains all of the arithmetic and logic operations (twelve in total) with additional “Try all” option;
  All the operations are: Add, Subtract, Multiply, Divide, AND, OR, XOR, Min, Max, Average, Difference, Transparent-zero.
  ![image](https://user-images.githubusercontent.com/86291178/123097632-fd6d7c00-d438-11eb-807e-22773ec21451.png)
  
*	Button “Make Calculation” – it allows the user to see the result of the chosen operation;
*	Button “Save” – it saves the result image;
*	Twelve JLabels – they display the result image(s) depending on the selected operation and underneath each one a description of the type of the operation has been placed;
*	JPanel - containing all of the above JLabel components.

The visibility of JLabel components is dynamically controlled and depends on selected type of processing. When one operation is chosen then only one JLabel component is visible in order to present result of image processing through selected arithmetic or logic operation and all other JLabel components are hidden. If the “Try all” option is selected then all twelve JLabel components are visible. The image below shows the workflow of ALOImagePro plugin. First step is to launch ImageJ program. Then it is necessary to open two images for processing. Next step is to start ALOImagePro plugin which is located on the “Plugins” menu of ImageJ’s menu bar. The main window of ALOImagePro plugin has two buttons and one choice component. The choice component is for operation choosing and the button “Make Calculation” apply selected operation(s) to the opened images. The second button (Save) is allowed only when one operation is selected. It could be used for result image save.

![image](https://user-images.githubusercontent.com/86291178/123096192-81beff80-d437-11eb-810a-c7e4b8ce9bd4.png)

The Plugin ALOImagePro is develloped in cooperation with Atanaska Bosakova-Ardenska [Link to Researchgate](https://www.researchgate.net/profile/Atanaska-Bosakova-Ardenska), Magdalina Kutryanska [Link to Researchgate](https://www.researchgate.net/profile/Magdalina-Kutryanska), Ivaylo Ivanov and Vladimir Karparov.

**For citation:** 
"_Danev A., A. Bosakova-Ardenska, M. Kutryanska, I. Ivanov, V. Karparov, (2020). 
APPLICATION OF ARITHMETIC AND LOGIC OPERATIONS FOR OBJECTS EXTRACTION IN IMAGEJ,
Scientific  Research  of  the  Union  of  Scientists  in  Bulgaria  –  Plovdiv,  
series  B. Natural Sciences and Humanities, Vol XX, ISSN: 1311- 9192 (Print), 
ISSN:2534-9376 (On-line), VIIIth International  Conference Of Young  Scientists 2020._"
