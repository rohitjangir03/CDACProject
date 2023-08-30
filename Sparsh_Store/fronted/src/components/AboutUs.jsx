import React from "react";
import "../css/aboutus.css";
import Navbar from "./Navbar";

const AboutUs = () => {
  return (
    <>
      <Navbar />
      <hr />
      <div className="py-5 service-26">
        <div className="container">
          <div className="row wrap-service-26" style={{marginLeft:"50%",fontSize:"25px",color:"black",fontWeight:"500"}}>
           ABOUT US
          </div>
          <div className="row wrap-service-26 mt-4 pt-3">
            <div className="col-md-6">
              <img
                src="https://images.pexels.com/photos/1470168/pexels-photo-1470168.jpeg?auto=compress&cs=tinysrgb&w=600"
                className="img-fluid"
              />
            </div>
            <div className="col-md-6 align-self-center">
              <span className="badge badge-info rounded-pill px-3 py-1 font-weight-light">
                Sparsh
              </span>
              <h3 className="mt-3">
                Get the {"&"} Plants to make your
                home look modern & Society looks beautiful!!!
              </h3>
              <p className="mt-3">
                Sparsh Store is an Indian Platform to provide plants for your farm, home and society.
                Can order variety of plants from our website
              </p>
              <p>
                <b>OUR MISSION</b> <br />
                Making india green and beautiful in every street, in every
                city,in every home.
                <br /><br />
                <b>VISION</b><br />
                To make INDIA Green and Happy!
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default AboutUs;
