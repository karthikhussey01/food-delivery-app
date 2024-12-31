const AUTH_TOKEN = 'token';

export const storeToken = (token: string) => {
  localStorage.setItem(AUTH_TOKEN, token);
};

export const getToken = (): string | null => {
  return localStorage.getItem(AUTH_TOKEN);
};
