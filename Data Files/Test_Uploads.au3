ControlFocus("[CLASS:#32770]","","Edit1")
Sleep(1000)
ControlSetText("[CLASS:#32770]","","Edit1",@ScriptDir&"\Case_Upload_Docs\Test"&$CmdLine[1])
ControlClick("[CLASS:#32770]","","Button1")