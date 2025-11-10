/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Request DTO class for login operation


export type LoginModel = {
    token: string;
    email: string;
    firstName: string;
    lastName: string;
    id: number;
    mobileNumber?: string;
    gender: string;
    country: string;
    language: string;
    role: string;
}