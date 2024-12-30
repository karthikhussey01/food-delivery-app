import { services } from './constants';

export const createEndpoint = (
  service: keyof typeof services,
  ...paths: string[]
): string => {
  return services[service] + paths.join('/');
};
