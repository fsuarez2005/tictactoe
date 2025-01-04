#!/usr/bin/env wish
proc window_main {} {
    grid [frame .f -padx 2 -pady 2 ] -column 0 -row 0
    tictactoe_board .f.

}

proc tictactoe_board {parent} {
    set button_height 10
    set button_width 10

    grid [button ${parent}button00 -text "" \
        -width $button_width -height $button_height \
        -command {setbutton ::button1text hello} \
        -textvariable button1text] -column 0 -row 0
    
    
}

proc setbutton {textvariable phrase} {
    set $textvariable $phrase
}


proc configure_window {window} {
    wm title $window "Tic-Tac-Toe"

}



proc main {} {
    configure_window .
    window_main
}

main





