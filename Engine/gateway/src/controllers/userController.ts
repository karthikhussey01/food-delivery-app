import axios from 'axios';
import { Request, Response } from 'express';
import { createEndpoint } from '../util/urlUtil';

const service = 'user';

export const login = async (req: Request, res: Response) => {
  try {
    const endpoint: string = createEndpoint(service, 'validate');
    const userServiceResp = await axios.post(endpoint, req.body);
    res.status(userServiceResp.status).json(userServiceResp.data);
  } catch (error) {
    console.error('Error occurred', error);
  }
};

export const register = async (req: Request, res: Response) => {
  try {
    const endpoint: string = createEndpoint(service, 'create');
    const userServiceResp = await axios.post(endpoint, req.body);
    res.status(userServiceResp.status).json(userServiceResp.data);
  } catch (error) {
    console.error('Error occurred', error);
  }
};
