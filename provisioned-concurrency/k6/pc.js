import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 10,
    duration: '10s',
};

export default function () {
    const apiGateway = 'https://glzylhyxcywjmxvjccbshvidwa.apigateway.ap-tokyo-1.oci.customer-oci.com/sa';
    http.get(`${apiGateway}/pc`);
    sleep(1);
}
