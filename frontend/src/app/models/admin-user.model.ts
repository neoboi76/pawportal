/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for admin user management operations

export interface User {
    showDropdown: any;
    userId: number;
    email: string;
    firstName: string;
    lastName: string;
    mobileNumber?: string;
    gender?: string;
    country?: string;
    language?: string;
    role: string;
    suspended: boolean;
    createdAt: string;
    applicationCount: number;
}
