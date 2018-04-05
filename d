[1mdiff --git a/.idea/workspace.xml b/.idea/workspace.xml[m
[1mindex c2b31e6..d46fc85 100644[m
[1m--- a/.idea/workspace.xml[m
[1m+++ b/.idea/workspace.xml[m
[36m@@ -1,7 +1,10 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
   <component name="ChangeListManager">[m
[31m-    <list default="true" id="cdb932d9-7e58-4d94-93a9-e7b232ef17da" name="Default" comment="" />[m
[32m+[m[32m    <list default="true" id="cdb932d9-7e58-4d94-93a9-e7b232ef17da" name="Default" comment="">[m
[32m+[m[32m      <change type="DELETED" beforePath="$PROJECT_DIR$/.idea/ant.xml" afterPath="" />[m
[32m+[m[32m      <change type="MODIFICATION" beforePath="$PROJECT_DIR$/.idea/workspace.xml" afterPath="$PROJECT_DIR$/.idea/workspace.xml" />[m
[32m+[m[32m    </list>[m
     <ignored path="JavaFxApplication.iws" />[m
     <ignored path=".idea/workspace.xml" />[m
     <ignored path="$PROJECT_DIR$/out/" />[m
[36m@@ -53,16 +56,15 @@[m
     <ui_properties converted="true" />[m
     <breakpoint_rules converted="true" />[m
   </component>[m
[31m-  <component name="ExecutionTargetManager" SELECTED_TARGET="default_target" />[m
   <component name="FavoritesManager">[m
     <favorites_list name="JavaFxApplication" />[m
   </component>[m
   <component name="FileEditorManager">[m
     <leaf SIDE_TABS_SIZE_LIMIT_KEY="300">[m
[31m-      <file leaf-file-name="Main.java" pinned="false" current-in-tab="true">[m
[32m+[m[32m      <file leaf-file-name="Main.java" pinned="false" current-in-tab="false">[m
         <entry file="file://$PROJECT_DIR$/src/sample/Main.java">[m
           <provider selected="true" editor-type-id="text-editor">[m
[31m-            <state relative-caret-position="111">[m
[32m+[m[32m            <state relative-caret-position="221">[m
               <caret line="13" column="40" lean-forward="false" selection-start-line="13" selection-start-column="40" selection-end-line="13" selection-end-column="40" />[m
               <folding>[m
                 <element signature="imports" expanded="true" />[m
[36m@@ -71,7 +73,7 @@[m
           </provider>[m
         </entry>[m
       </file>[m
[31m-      <file leaf-file-name="Controller.java" pinned="false" current-in-tab="false">[m
[32m+[m[32m      <file leaf-file-name="Controller.java" pinned="false" current-in-tab="true">[m
         <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
           <provider selected="true" editor-type-id="text-editor">[m
             <state relative-caret-position="68">[m
[36m@@ -83,15 +85,15 @@[m
       </file>[m
       <file leaf-file-name="sample.fxml" pinned="false" current-in-tab="false">[m
         <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
[32m+[m[32m          <provider editor-type-id="JavaFX-Scene-Builder">[m
[32m+[m[32m            <state />[m
[32m+[m[32m          </provider>[m
           <provider selected="true" editor-type-id="text-editor">[m
             <state relative-caret-position="119">[m
               <caret line="7" column="11" lean-forward="false" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
               <folding />[m
             </state>[m
           </provider>[m
[31m-          <provider editor-type-id="JavaFX-Scene-Builder">[m
[31m-            <state />[m
[31m-          </provider>[m
         </entry>[m
       </file>[m
     </leaf>[m
[36m@@ -101,6 +103,9 @@[m
       <setting name="OPEN_NEW_TAB" value="false" />[m
     </FindUsagesManager>[m
   </component>[m
[32m+[m[32m  <component name="Git.Settings">[m
[32m+[m[32m    <option name="RECENT_GIT_ROOT_PATH" value="$PROJECT_DIR$" />[m
[32m+[m[32m  </component>[m
   <component name="GradleLocalSettings">[m
     <option name="externalProjectsViewState">[m
       <projects_view />[m
[36m@@ -115,10 +120,9 @@[m
   </component>[m
   <component name="PhpWorkspaceProjectConfiguration" backward_compatibility_performed="true" />[m
   <component name="ProjectFrameBounds">[m
[31m-    <option name="x" value="108" />[m
[31m-    <option name="y" value="84" />[m
[31m-    <option name="width" value="879" />[m
[31m-    <option name="height" value="575" />[m
[32m+[m[32m    <option name="x" value="953" />[m
[32m+[m[32m    <option name="width" value="974" />[m
[32m+[m[32m    <option name="height" value="1057" />[m
   </component>[m
   <component name="ProjectReloadState">[m
     <option name="STATE" value="0" />[m
[36m@@ -138,11 +142,11 @@[m
       <foldersAlwaysOnTop value="true" />[m
     </navigator>[m
     <panes>[m
[32m+[m[32m      <pane id="Scope" />[m
       <pane id="PackagesPane" />[m
       <pane id="ProjectPane" />[m
[31m-      <pane id="Scratches" />[m
[31m-      <pane id="Scope" />[m
       <pane id="AndroidView" />[m
[32m+[m[32m      <pane id="Scratches" />[m
     </panes>[m
   </component>[m
   <component name="PropertiesComponent">[m
[36m@@ -171,12 +175,26 @@[m
     </option>[m
   </component>[m
   <component name="RunManager" selected="Application.Main">[m
[31m-    <configuration default="true" type="#org.jetbrains.idea.devkit.run.PluginConfigurationType" factoryName="Plugin">[m
[31m-      <module name="" />[m
[31m-      <option name="VM_PARAMETERS" value="-Xmx512m -Xms256m -XX:MaxPermSize=250m" />[m
[32m+[m[32m    <configuration name="Main" type="Application" factoryName="Application">[m
[32m+[m[32m      <extension name="coverage" enabled="false" merge="false" sample_coverage="true" runner="idea">[m
[32m+[m[32m        <pattern>[m
[32m+[m[32m          <option name="PATTERN" value="sample.*" />[m
[32m+[m[32m          <option name="ENABLED" value="true" />[m
[32m+[m[32m        </pattern>[m
[32m+[m[32m      </extension>[m
[32m+[m[32m      <option name="MAIN_CLASS_NAME" value="sample.Main" />[m
[32m+[m[32m      <option name="VM_PARAMETERS" />[m
       <option name="PROGRAM_PARAMETERS" />[m
[31m-      <predefined_log_file id="idea.log" enabled="true" />[m
[31m-      <method />[m
[32m+[m[32m      <option name="WORKING_DIRECTORY" value="$PROJECT_DIR$" />[m
[32m+[m[32m      <option name="ALTERNATIVE_JRE_PATH_ENABLED" value="false" />[m
[32m+[m[32m      <option name="ALTERNATIVE_JRE_PATH" />[m
[32m+[m[32m      <option name="ENABLE_SWING_INSPECTOR" value="false" />[m
[32m+[m[32m      <option name="ENV_VARIABLES" />[m
[32m+[m[32m      <option name="PASS_PARENT_ENVS" value="true" />[m
[32m+[m[32m      <module name="Store" />[m
[32m+[m[32m      <envs />[m
[32m+[m[32m      <RunnerSettings RunnerId="Run" />[m
[32m+[m[32m      <ConfigurationWrapper RunnerId="Run" />[m
     </configuration>[m
     <configuration default="true" type="Applet" factoryName="Applet">[m
       <module />[m
[36m@@ -185,7 +203,6 @@[m
       <option name="HEIGHT" value="300" />[m
       <option name="POLICY_FILE" value="$APPLICATION_HOME_DIR$/bin/appletviewer.policy" />[m
       <option name="ALTERNATIVE_JRE_PATH_ENABLED" value="false" />[m
[31m-      <method />[m
     </configuration>[m
     <configuration default="true" type="Application" factoryName="Application">[m
       <extension name="coverage" enabled="false" merge="false" sample_coverage="true" runner="idea" />[m
[36m@@ -200,7 +217,6 @@[m
       <option name="PASS_PARENT_ENVS" value="true" />[m
       <module name="" />[m
       <envs />[m
[31m-      <method />[m
     </configuration>[m
     <configuration default="true" type="JUnit" factoryName="JUnit">[m
       <extension name="coverage" enabled="false" merge="false" sample_coverage="true" runner="idea" />[m
[36m@@ -221,7 +237,12 @@[m
       </option>[m
       <envs />[m
       <patterns />[m
[31m-      <method />[m
[32m+[m[32m    </configuration>[m
[32m+[m[32m    <configuration default="true" type="#org.jetbrains.idea.devkit.run.PluginConfigurationType" factoryName="Plugin">[m
[32m+[m[32m      <module name="" />[m
[32m+[m[32m      <option name="VM_PARAMETERS" value="-Xmx512m -Xms256m -XX:MaxPermSize=250m" />[m
[32m+[m[32m      <option name="PROGRAM_PARAMETERS" />[m
[32m+[m[32m      <predefined_log_file id="idea.log" enabled="true" />[m
     </configuration>[m
     <configuration default="true" type="Remote" factoryName="Remote">[m
       <option name="USE_SOCKET_TRANSPORT" value="true" />[m
[36m@@ -229,7 +250,6 @@[m
       <option name="SHMEM_ADDRESS" value="javadebug" />[m
       <option name="HOST" value="localhost" />[m
       <option name="PORT" value="5005" />[m
[31m-      <method />[m
     </configuration>[m
     <configuration default="true" type="TestNG" factoryName="TestNG">[m
       <extension name="coverage" enabled="false" merge="false" sample_coverage="true" runner="idea" />[m
[36m@@ -257,33 +277,7 @@[m
       <envs />[m
       <properties />[m
       <listeners />[m
[31m-      <method />[m
     </configuration>[m
[31m-    <configuration default="false" name="Main" type="Application" factoryName="Application">[m
[31m-      <extension name="coverage" enabled="false" merge="false" sample_coverage="true" runner="idea">[m
[31m-        <pattern>[m
[31m-          <option name="PATTERN" value="sample.*" />[m
[31m-          <option name="ENABLED" value="true" />[m
[31m-        </pattern>[m
[31m-      </extension>[m
[31m-      <option name="MAIN_CLASS_NAME" value="sample.Main" />[m
[31m-      <option name="VM_PARAMETERS" />[m
[31m-      <option name="PROGRAM_PARAMETERS" />[m
[31m-      <option name="WORKING_DIRECTORY" value="$PROJECT_DIR$" />[m
[31m-      <option name="ALTERNATIVE_JRE_PATH_ENABLED" value="false" />[m
[31m-      <option name="ALTERNATIVE_JRE_PATH" />[m
[31m-      <option name="ENABLE_SWING_INSPECTOR" value="false" />[m
[31m-      <option name="ENV_VARIABLES" />[m
[31m-      <option name="PASS_PARENT_ENVS" value="true" />[m
[31m-      <module name="Store" />[m
[31m-      <envs />[m
[31m-      <RunnerSettings RunnerId="Run" />[m
[31m-      <ConfigurationWrapper RunnerId="Run" />[m
[31m-      <method />[m
[31m-    </configuration>[m
[31m-    <list size="1">[m
[31m-      <item index="0" class="java.lang.String" itemvalue="Application.Main" />[m
[31m-    </list>[m
     <configuration name="&lt;template&gt;" type="WebApp" default="true" selected="false">[m
       <Host>localhost</Host>[m
       <Port>5050</Port>[m
[36m@@ -307,39 +301,39 @@[m
     <option name="totallyTimeSpent" value="1302000" />[m
   </component>[m
   <component name="ToolWindowManager">[m
[31m-    <frame x="108" y="84" width="879" height="575" extended-state="0" />[m
[32m+[m[32m    <frame x="953" y="0" width="974" height="1057" extended-state="0" />[m
     <editor active="true" />[m
     <layout>[m
       <window_info id="Palette" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
       <window_info id="TODO" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="6" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Nl-Palette" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="-1" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Messages" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
       <window_info id="Palette&#9;" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="4" side_tool="false" content_ui="tabs" />[m
       <window_info id="Image Layers" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
       <window_info id="Capture Analysis" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="4" side_tool="false" content_ui="tabs" />[m
       <window_info id="Event Log" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
       <window_info id="Maven Projects" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Run" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.32962447" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Version Control" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="false" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Properties" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="-1" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Version Control" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Run" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.32946146" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
       <window_info id="Terminal" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
       <window_info id="Capture Tool" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
       <window_info id="Designer" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Project" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="true" show_stripe_button="true" weight="0.1892552" sideWeight="0.6703755" order="0" side_tool="false" content_ui="combo" />[m
[32m+[m[32m      <window_info id="Project" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="true" show_stripe_button="true" weight="0.17014614" sideWeight="0.6703755" order="0" side_tool="false" content_ui="combo" />[m
       <window_info id="Structure" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.25" sideWeight="0.5" order="1" side_tool="false" content_ui="tabs" />[m
       <window_info id="Ant Build" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.25" sideWeight="0.5" order="1" side_tool="false" content_ui="tabs" />[m
       <window_info id="UI Designer" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
       <window_info id="Theme Preview" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="4" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Debug" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.4" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
       <window_info id="Favorites" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Debug" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.4" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
       <window_info id="Cvs" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.25" sideWeight="0.5" order="4" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Nl-Palette" active="false" anchor="left" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="2" side_tool="false" content_ui="tabs" />[m
       <window_info id="Message" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="0" side_tool="false" content_ui="tabs" />[m
       <window_info id="Commander" active="false" anchor="right" auto_hide="false" internal_type="SLIDING" type="SLIDING" visible="false" show_stripe_button="true" weight="0.4" sideWeight="0.5" order="0" side_tool="false" content_ui="tabs" />[m
       <window_info id="Application Servers" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
[32m+[m[32m      <window_info id="Properties" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="4" side_tool="false" content_ui="tabs" />[m
       <window_info id="Hierarchy" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.25" sideWeight="0.5" order="2" side_tool="false" content_ui="combo" />[m
       <window_info id="Profiler" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
       <window_info id="Database" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
       <window_info id="Changes" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
[31m-      <window_info id="Messages" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
       <window_info id="Inspection" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.4" sideWeight="0.5" order="5" side_tool="false" content_ui="tabs" />[m
       <window_info id="JetGradle" active="false" anchor="right" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="3" side_tool="false" content_ui="tabs" />[m
       <window_info id="Problems" active="false" anchor="bottom" auto_hide="false" internal_type="DOCKED" type="DOCKED" visible="false" show_stripe_button="true" weight="0.33" sideWeight="0.5" order="7" side_tool="false" content_ui="tabs" />[m
[36m@@ -360,8 +354,8 @@[m
   <component name="editorHistoryManager">[m
     <entry file="file://$PROJECT_DIR$/src/sample/Main.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
[31m-        <state relative-caret-position="68">[m
[31m-          <caret line="8" column="0" lean-forward="false" selection-start-line="8" selection-start-column="0" selection-end-line="8" selection-end-column="0" />[m
[32m+[m[32m        <state relative-caret-position="0">[m
[32m+[m[32m          <caret line="0" column="0" lean-forward="false" selection-start-line="0" selection-start-column="0" selection-end-line="0" selection-end-column="0" />[m
           <folding>[m
             <element signature="imports" expanded="true" />[m
           </folding>[m
[36m@@ -370,22 +364,22 @@[m
     </entry>[m
     <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
[31m-        <state relative-caret-position="0">[m
[31m-          <caret line="0" column="0" lean-forward="false" selection-start-line="0" selection-start-column="0" selection-end-line="0" selection-end-column="0" />[m
[32m+[m[32m        <state relative-caret-position="68">[m
[32m+[m[32m          <caret line="4" column="0" lean-forward="false" selection-start-line="4" selection-start-column="0" selection-end-line="4" selection-end-column="0" />[m
           <folding />[m
         </state>[m
       </provider>[m
     </entry>[m
     <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
[32m+[m[32m      <provider editor-type-id="JavaFX-Scene-Builder">[m
[32m+[m[32m        <state />[m
[32m+[m[32m      </provider>[m
       <provider selected="true" editor-type-id="text-editor">[m
         <state relative-caret-position="119">[m
           <caret line="7" column="11" lean-forward="false" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
           <folding />[m
         </state>[m
       </provider>[m
[31m-      <provider editor-type-id="JavaFX-Scene-Builder">[m
[31m-        <state />[m
[31m-      </provider>[m
     </entry>[m
     <entry file="file://$PROJECT_DIR$/src/sample/Main.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
[36m@@ -397,21 +391,42 @@[m
         </state>[m
       </provider>[m
     </entry>[m
[31m-    <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
[32m+[m[32m    <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
[31m-        <state relative-caret-position="119">[m
[31m-          <caret line="7" column="11" lean-forward="true" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
[32m+[m[32m        <state relative-caret-position="0">[m
[32m+[m[32m          <caret line="0" column="0" lean-forward="false" selection-start-line="0" selection-start-column="0" selection-end-line="0" selection-end-column="0" />[m
           <folding />[m
         </state>[m
       </provider>[m
[32m+[m[32m    </entry>[m
[32m+[m[32m    <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
       <provider editor-type-id="JavaFX-Scene-Builder">[m
         <state />[m
       </provider>[m
[32m+[m[32m      <provider selected="true" editor-type-id="text-editor">[m
[32m+[m[32m        <state relative-caret-position="119">[m
[32m+[m[32m          <caret line="7" column="11" lean-forward="false" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
[32m+[m[32m          <folding />[m
[32m+[m[32m        </state>[m
[32m+[m[32m      </provider>[m
     </entry>[m
[31m-    <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
[32m+[m[32m    <entry file="file://$PROJECT_DIR$/src/sample/Main.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
         <state relative-caret-position="68">[m
[31m-          <caret line="4" column="0" lean-forward="true" selection-start-line="4" selection-start-column="0" selection-end-line="4" selection-end-column="0" />[m
[32m+[m[32m          <caret line="8" column="0" lean-forward="false" selection-start-line="8" selection-start-column="0" selection-end-line="8" selection-end-column="0" />[m
[32m+[m[32m          <folding>[m
[32m+[m[32m            <element signature="imports" expanded="true" />[m
[32m+[m[32m          </folding>[m
[32m+[m[32m        </state>[m
[32m+[m[32m      </provider>[m
[32m+[m[32m    </entry>[m
[32m+[m[32m    <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
[32m+[m[32m      <provider editor-type-id="JavaFX-Scene-Builder">[m
[32m+[m[32m        <state />[m
[32m+[m[32m      </provider>[m
[32m+[m[32m      <provider selected="true" editor-type-id="text-editor">[m
[32m+[m[32m        <state relative-caret-position="119">[m
[32m+[m[32m          <caret line="7" column="11" lean-forward="true" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
           <folding />[m
         </state>[m
       </provider>[m
[36m@@ -419,25 +434,25 @@[m
     <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
         <state relative-caret-position="68">[m
[31m-          <caret line="4" column="0" lean-forward="false" selection-start-line="4" selection-start-column="0" selection-end-line="4" selection-end-column="0" />[m
[32m+[m[32m          <caret line="4" column="0" lean-forward="true" selection-start-line="4" selection-start-column="0" selection-end-line="4" selection-end-column="0" />[m
           <folding />[m
         </state>[m
       </provider>[m
     </entry>[m
     <entry file="file://$PROJECT_DIR$/src/sample/sample.fxml">[m
[32m+[m[32m      <provider editor-type-id="JavaFX-Scene-Builder">[m
[32m+[m[32m        <state />[m
[32m+[m[32m      </provider>[m
       <provider selected="true" editor-type-id="text-editor">[m
         <state relative-caret-position="119">[m
           <caret line="7" column="11" lean-forward="false" selection-start-line="7" selection-start-column="11" selection-end-line="7" selection-end-column="11" />[m
           <folding />[m
         </state>[m
       </provider>[m
[31m-      <provider editor-type-id="JavaFX-Scene-Builder">[m
[31m-        <state />[m
[31m-      </provider>[m
     </entry>[m
     <entry file="file://$PROJECT_DIR$/src/sample/Main.java">[m
       <provider selected="true" editor-type-id="text-editor">[m
[31m-        <state relative-caret-position="111">[m
[32m+[m[32m        <state relative-caret-position="221">[m
           <caret line="13" column="40" lean-forward="false" selection-start-line="13" selection-start-column="40" selection-end-line="13" selection-end-column="40" />[m
           <folding>[m
             <element signature="imports" expanded="true" />[m
[36m@@ -445,5 +460,13 @@[m
         </state>[m
       </provider>[m
     </entry>[m
[32m+[m[32m    <entry file="file://$PROJECT_DIR$/src/sample/Controller.java">[m
[32m+[m[32m      <provider selected="true" editor-type-id="text-editor">[m
[32m+[m[32m        <state relative-caret-position="68">[m
[32m+[m[32m          <caret line="4" column="0" lean-forward="false" selection-start-line="4" selection-start-column="0" selection-end-line="4" selection-end-column="0" />[m
[32m+[m[32m          <folding />[m
[32m+[m[32m        </state>[m
[32m+[m[32m      </provider>[m
[32m+[m[32m    </entry>[m
   </component>[m
 </project>[m
\ No newline at end of file[m
