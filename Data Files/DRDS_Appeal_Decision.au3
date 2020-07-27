ShellExecute('C:\Katalon\Appeal_Decision.dotx')
Sleep(2000)
WinWaitActive("Document1 - Word")
WinSetState("Document1 - Word", "", @SW_MAXIMIZE)
ControlFocus("Document1 - Word", "", "[CLASS:NetUIHWND; INSTANCE:1]") ;focus on LHS control
ControlClick("Document1 - Word", "", "[CLASS:NetUIHWND; INSTANCE:1]", "Left", 1, 1403, 90) ;click '' button
Sleep(10000)
ControlClick("Document1 - Word", "", "[CLASS:Internet Explorer_Server; INSTANCE:1]", "Left", 1, 35, 101) ;click '' button
Send($CmdLine[1])  ; Enter the Appeal number
ControlClick("Document1 - Word", "", "[CLASS:Internet Explorer_Server; INSTANCE:1]", "Left", 1, 157, 150) ;click '' button
Sleep(10000)
Send("{ALT}"&"F"&"A"&"O")
ControlFocus("Save As","","[CLASS:Edit; INSTANCE:1]")
Sleep(1000)
ControlSetText("Save As","","[CLASS:Edit; INSTANCE:1]",@ScriptDir & "\DRDS\" & $CmdLine[1])
Sleep(1000)
Send("{TAB}")
Send("{DOWN 13}")
Send("{ENTER}")
ControlClick("Save As","","[CLASS:Button; INSTANCE:8]")
Sleep(2000)
Send("{TAB}" & "{TAB}" & "{TAB}" & "{TAB}" & "{TAB}" & "{SPACE}")
Sleep(1000)
Send("{ALT}"&"F"&"X")