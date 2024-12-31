import React, { useState } from 'react';
import { Button, Card, Typography } from 'antd';
import InputField from '../components/InputField';
import { login } from '../services/AuthService';

const { Title, Text } = Typography;

const AuthPage: React.FC = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
    firstname: '',
    lastname: '',
  });

  const [isRegistering, setIsRegistering] = useState(false);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (isRegistering) {
      console.log('Registration form submitted:', formData);
    } else {
      console.log('Login form submitted:', formData);
      login(formData.username, formData.password);
    }
  };

  const toggleForm = () => {
    setIsRegistering((prev) => !prev);
  };

  return (
    <div className='flex justify-center items-center min-h-screen bg-gray-50'>
      <Card
        className='w-full max-w-sm'
        style={{ padding: '20px', borderRadius: '8px' }}
        title={null}
        bordered={false}
      >
        <Title level={2} className='text-center text-gray-700 mb-6'>
          {isRegistering ? 'Create an Account' : 'Login to Your Account'}
        </Title>

        <form onSubmit={handleSubmit}>
          <InputField
            label='Username'
            type='text'
            name='username'
            value={formData.username}
            onChange={handleChange}
            placeholder='Enter your username'
          />

          <InputField
            label='Password'
            type='password'
            name='password'
            value={formData.password}
            onChange={handleChange}
            placeholder='Enter your password'
          />

          {isRegistering && (
            <>
              <InputField
                label='Email'
                type='email'
                name='email'
                value={formData.email}
                onChange={handleChange}
                placeholder='Enter your email address'
              />

              <InputField
                label='First Name'
                type='text'
                name='firstname'
                value={formData.firstname}
                onChange={handleChange}
                placeholder='Enter your first name'
              />

              <InputField
                label='Last Name'
                type='text'
                name='lastname'
                value={formData.lastname}
                onChange={handleChange}
                placeholder='Enter your last name'
              />
            </>
          )}

          <Button
            type='primary'
            htmlType='submit'
            className='w-full mt-4'
            size='large'
            style={{ backgroundColor: '#4c6ef5', borderColor: '#4c6ef5' }}
          >
            {isRegistering ? 'Register' : 'Login'}
          </Button>
        </form>

        <div className='mt-4 text-center'>
          <Text className='text-sm'>
            {isRegistering ? (
              <>
                Already have an account?{' '}
                <Button type='link' onClick={toggleForm} style={{ padding: 0 }}>
                  Login here
                </Button>
              </>
            ) : (
              <>
                Don't have an account?{' '}
                <Button type='link' onClick={toggleForm} style={{ padding: 0 }}>
                  Register here
                </Button>
              </>
            )}
          </Text>
        </div>
      </Card>
    </div>
  );
};

export default AuthPage;
