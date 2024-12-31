import axios from 'axios';
import { storeToken } from '../util/tokenUtil';

const API_URL = 'http://localhost:3000/app';

import { AxiosError } from 'axios';

export const login = async (
  username: string,
  password: string
): Promise<void> => {
  try {
    const response = await axios.post(`${API_URL}/login`, {
      username,
      password,
    });
    storeToken(response.data);
  } catch (error: unknown) {
    if (error instanceof AxiosError && error.response) {
      throw new Error(error.response.data.message || 'Login failed');
    }
    throw new Error((error as Error).message || 'Something went wrong');
  }
};
