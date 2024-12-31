import express from 'express';
import { login, register } from '../controllers/userController';
import { restaurant, restaurants } from '../controllers/restaurantController';

const router = express.Router();

router.post('/login', login);
router.post('/register', register);

router.get('/restaurants', restaurants);
router.get('/restaurant/:id', restaurant);

export default router;
