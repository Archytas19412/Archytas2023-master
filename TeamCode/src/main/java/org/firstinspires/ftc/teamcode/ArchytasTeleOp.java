package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "ArchytasTeleOp")
public class ArchytasTeleOp extends OpMode {

    //Create variables
    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftFront;
    DcMotor LeftBack;
    DcMotor Lift;
    Servo Claw;

    //Method init: every function once init button is pressed
    public  void init(){
       RightFront = hardwareMap.dcMotor.get("RightFront");
       RightBack = hardwareMap.dcMotor.get("RightBack");
       LeftFront = hardwareMap.dcMotor.get("LeftFront");
       LeftBack = hardwareMap.dcMotor.get("LeftBack");
       Claw = hardwareMap.servo.get("Claw");

       RightFront.setDirection(DcMotor.Direction.REVERSE);
       RightBack.setDirection(DcMotor.Direction.REVERSE);

    }

    //Be constantly in loop once press play
    public void loop(){
        //Forward and backwards + Right and left + Turn right and left
        double forward = gamepad1.left_stick_y;
        double shuffling = gamepad1.left_stick_x;
        double turning = gamepad1.right_stick_x;

        RightFront.setPower(forward - shuffling - turning);
        RightBack.setPower(forward + shuffling - turning);
        LeftFront.setPower(forward + shuffling + turning);
        LeftBack.setPower(forward - shuffling + turning);

        //Opening and closing claw
        if(gamepad2.a){
            Claw.setPosition(1);
        }
        if(gamepad2.b){
            Claw.setPosition(0);
        }
    }
    //Bottom of the Program
}
