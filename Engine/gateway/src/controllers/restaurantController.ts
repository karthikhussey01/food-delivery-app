import axios from 'axios';
import { Request, Response } from 'express';
import { createEndpoint } from '../util/urlUtil';

const service = 'restaurant';
export const restaurants = async (req: Request, res: Response) => {
  try {
    const endpoint: string = createEndpoint(service, 'restaurant');
    console.log(endpoint);
    const resServiceResp = await axios.get(endpoint);
    res.status(resServiceResp.status).json(resServiceResp.data);
  } catch (e) {
    setError(res, e);
  }
};

export const restaurant = async (req: Request, res: Response) => {
  try {
    const { id } = req.params;
    const endpoint: string = createEndpoint(service, 'restaurant', id);
    const resServiceResp = await axios.get(endpoint);
    res.status(resServiceResp.status).json(resServiceResp.data);
  } catch (e) {
    setError(res, e);
  }
};

const setError = (res: Response, e: unknown) => {
  console.log('Error occurred ', e);
  res.status(500).json({ error: 'Error occurred' });
};
