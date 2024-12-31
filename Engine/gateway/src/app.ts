import express from 'express';
import cors from 'cors';
import router from './routes/router';
import dotenv from 'dotenv';

dotenv.config();

const app = express();
const port = process.env.REACT_APP_PORT || 5173;

const corsOptions = {
  origin: `http://localhost:${port}`,
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
};

app.use(cors(corsOptions));
app.use(express.json());

app.use('/app', router);

export default app;
