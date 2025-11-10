/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Request DTO class for reset-password operation

export type ResetPasswordModel = {
    email: string;
    oldPassword: string;
    newPassword: string;
}