import React, { useState } from 'react';
import InputField from '../components/InputField';

const AuthPage: React.FC = () => {
  // State to manage form data
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
    firstname: '',
    lastname: '',
  });

  // State to toggle between login and registration
  const [isRegistering, setIsRegistering] = useState(false);

  // Handle form input changes
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle form submission
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (isRegistering) {
      console.log('Registration form submitted:', formData);
      // You can add API call for registration here
    } else {
      console.log('Login form submitted:', formData);
      // You can add API call for login here
    }
  };

  // Toggle between Login and Register form
  const toggleForm = () => {
    setIsRegistering((prev) => !prev);
  };

  return (
    <div className='flex justify-center items-center min-h-screen bg-gray-50'>
      <div className='w-full max-w-sm p-6 bg-white rounded-lg shadow-md'>
        <h2 className='text-2xl font-semibold text-center text-gray-700 mb-6'>
          {isRegistering ? 'Create an Account' : 'Login to Your Account'}
        </h2>

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

          <button
            type='submit'
            className='w-full py-2 mt-4 bg-indigo-600 text-white rounded-md hover:bg-indigo-700'
          >
            {isRegistering ? 'Register' : 'Login'}
          </button>
        </form>

        <div className='mt-4 text-center'>
          <p className='text-sm'>
            {isRegistering ? (
              <>
                Already have an account?{' '}
                <button
                  onClick={toggleForm}
                  className='text-indigo-600 hover:underline'
                >
                  Login here
                </button>
              </>
            ) : (
              <>
                Don't have an account?{' '}
                <button
                  onClick={toggleForm}
                  className='text-indigo-600 hover:underline'
                >
                  Register here
                </button>
              </>
            )}
          </p>
        </div>
      </div>
    </div>
  );
};

export default AuthPage;
