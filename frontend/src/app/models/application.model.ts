/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for application forms 


export interface ApplicationForm {
  applicationId?: number;
  dogId?: number;
  userId?: number;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  address: string;
  city: string;
  postalCode: string;
  occupation: string;
  livingStatus: string;
  reasonForAdoption: string;
  experience: string;
  status?: string;
  submittedAt?: string;
}
