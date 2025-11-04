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
