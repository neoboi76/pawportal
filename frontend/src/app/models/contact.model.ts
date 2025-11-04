export interface ContactForm {
  contactId?: number;
  name: string;
  email: string;
  phone: string;
  subject: string;
  message: string;
  submittedAt?: string;
}